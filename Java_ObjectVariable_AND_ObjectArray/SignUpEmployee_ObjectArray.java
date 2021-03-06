package Java_ObjectVariable_AND_ObjectArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    請幫公司建立一套人事管理系統，該系統允許輸入員工資料，並儲存於資料檔案內（Human.data）。
    假設登錄員工資料包含有：員工代號（int）、姓名（String）、工作部門（String）、底薪（int）、職務加級（int）。
    期望操作介面，以及檔案輸出結果如下：

    ***** 輸入員工資料 *****
    輸入員工姓名 =>劉明新
    輸入所屬部門 =>行銷課
    輸入員工代號 =>71242
    輸入員工底薪 =>31000
    輸入薪資加級 =>15000
    是否繼續輸入員工資料 (yes/no) =>no
    ***** 將員工資料輸出到 Human.dada 檔案內 ****
    ***** 輸出完畢 ****

    G:\Examples\chap9\Ex6_1>dir/b
    Employee.class
    Human.data
    Ex88_1.java
    Ex88_1.class

    G:\Examples\chap9\Ex6_1>type Human.data        【type 顯示檔案內容命令】
    71219   陳中心  倉管課  32000   17000
    71242   劉明新  行銷課  31000   15000

    本系統製作要點是，宣告產生一個物件陣列將連續輸入的員工資料寫入其中，
    輸入完畢之後，再將物件陣列內容一筆接一筆寫入輸出檔案上。
    要注意的是，輸出檔案上每一行存放一筆員工資料，資料的每個屬性分別由一個欄位表示。
 */


/* 物件陣列的類別宣告 */
class Employee_1{
    int ID;                         //員工代號（Key）
    String name;                    //員工姓名
    String department;              //部門
    int payment;                    //底薪
    int duty;                       //職務加給
}

public class SignUpEmployee_ObjectArray {
    public static void main(String[] args) throws IOException {                     //如果有錯誤就把錯誤訊息丟到 IOEception底下
        Scanner keyin = new Scanner(System.in);
        Employee_1[] worker = new Employee_1[20];

        /* 宣告輸出檔案物件 */
        String file = "Human.data";                                                 //宣告產生一個緩衝器型的輸出檔案物件，指定該檔案名稱為 Human.data
        BufferedWriter data = new BufferedWriter(new FileWriter(file));             //宣告一個BufferWriter的物件叫做 data, 然後產生FileWriter把file丟進去。
        int k = 0;                                                                  //讀取幾筆資料我們用一個變數，而且是一個全域變數要讓任何物件、方法都可以使用它
        String select;                                                              //宣告一個 select 去做選擇 yse/no

        /* 讀入資料並存入物件陣列內 */
        System.out.printf("是否繼續輸入員工資料(yes/no) =>");
        select = keyin.nextLine();
        while (select.equals("yes") && (k<20)){                                     //如果輸入 yes 而且 k<20兩個條件都達成就可以寫入
            worker[k] = new Employee_1();
            System.out.printf("*****輸入員工資料*****\n");
            System.out.printf("輸入員工姓名 =>");
            worker[k].name = keyin.nextLine();
            System.out.printf("輸入所屬部門 =>");
            worker[k].department = keyin.nextLine();
            System.out.printf("輸入員工代號 =>");
            worker[k].ID = keyin.nextInt();
            System.out.printf("輸入員工薪資 =>");
            worker[k].payment = keyin.nextInt();
            System.out.printf("輸入職務加給 =>");
            worker[k].duty = keyin.nextInt();
            keyin.nextLine();                                                        //清除鍵盤輸入
            System.out.printf("是否繼續輸入員工資料 (yes/no) =>");
            select = keyin.nextLine();
            k = k + 1;                                                               //如果都完成寫入會加上1，可以持續輸入最多20個資料為止
        }

        /* 物件讀完要把它寫入檔案內 */
        System.out.printf("*** 將員工資料輸出到 Human.dada 檔案內 **\n");
        for (int i=0; i<k; i++){                                                     // 將物件陣列內資料一筆接一筆連續寫入 data 檔案物件；其中 data.write() 為檔案物件的寫入方法。資料屬性之間以『tab』鍵空格位置（\t）最後屬性輸出後跳至下一行（\n）。i < k, 因為k會不斷地讀入我們輸入的資料一定會比 i 大。
            data.write(worker[i].ID + "\t");
            data.write(worker[i].name + "\t");
            data.write(worker[i].department + "\t");
            data.write(worker[i].payment + "\t");
            data.write(worker[i].duty + "\n");
        }
        data.close();                                                                //寫入完成記得要關閉，目的是強迫將緩衝器內容輸出到檔案上
        System.out.printf("***** 輸出完畢 ****\n");

    }
}
