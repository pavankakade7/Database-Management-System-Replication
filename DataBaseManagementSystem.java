
import java.util.*;

class Student
{

    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static
    {
        Generator = 0;
    }


    public Student( String str, int X, int Y)
    {
        this.Rno = ++Generator;
        this.Name = str;
        this.Age = X;
        this.Marks = Y;

    }

    public void Display()
    {
        System.out.println(this.Rno + " " + this.Name + " " + this.Age + " " + this.Marks);
    }

}

class DBMS
{
    public LinkedList <Student> lobj; // refernce of linked list 

    public DBMS()
    {
        lobj = new LinkedList<Student>();
    }

    public void StartDBMS()
    {
        System.out.println("DBMS Started Successfully...");
        System.out.println("Table Schema created Successfully...");

        // Logic will coming soon...
        String Query;
        String Tokens[];

        Scanner sobj = new Scanner(System.in);
        int TokensCount = 0;
        while(true)
        {
             System.out.println("DBMS : ");
             Query = sobj.nextLine();
             Tokens = Query.split(" ");

             TokensCount = Tokens.length;

             if(TokensCount == 1)
             {
                if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you for using DBMS...");
                    break;
                }
             }
             else if(TokensCount == 2)
             {

             }
             else if(TokensCount == 3)
             {

             }
             else if (TokensCount == 4)
             {
                if("select".equals(Tokens[0]))
                {
                    SelectFrom();
                }
             }
             else if (TokensCount == 5)
             {
                if("select".equals(Tokens[0]))
                {
                    if("Max".equals(Tokens[1]))
                    {
                        System.out.println("Maximum marks are : " + Aggregate_Max());
                    }
                    else if("Min".equals(Tokens[1]))
                    {
                        System.out.println("Minimum marks are : " + Aggregate_Min());

                    }
                    else if("AVG".equals(Tokens[1]))
                    {
                        System.out.println("Average marks are : " + Aggregate_AVG());
                    }
                    else if("SUM".equals(Tokens[1]))
                    {
                        System.out.println("Addition of marks are : " + Aggregate_Sum());
                    }
                }
             }
             else if (TokensCount == 6)
             {

             }
             else if (TokensCount == 7)
             {
                if("insert".equals((Tokens[0])))
                {
                  InsertIntoTables(Tokens[4],Integer.parseInt(Tokens[5]), Integer.parseInt(Tokens[6]));
                }
                else if("delete".equals(Tokens[0]))
                {
                    DeleteFrom(Integer.parseInt(Tokens[6]));
                }
             }
        }
       
        
    }
    // insert into tables student valeus(____,_____,____);
    public void InsertIntoTables(String name, int age, int marks)
    {
        Student sobj = new Student(name,age,marks);
        //using collection we add data into tables
        lobj.add(sobj); //student cha record insert jahla

    }

    // select * from student

    public void SelectFrom()
    {
        System.out.println("Records from the student table are : ");
        for(Student sref : lobj)
        {
            sref.Display();
        }
    }

    // select * from student where Rno = 1

     public void SelectFrom(int no)
    {
        System.out.println("Record from the student table where Roll No  : "+ no);
        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                sref.Display();
                break;
            }
           
            
        }
    }

    // select * from student where Name = 'Rahul'

    public void SelectFrom(String str)
    {
        System.out.println("Record from the student table where Roll No  : ");
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.Display();
                break;
            }
           
            
        }
    }

    // select Max(marks) from student

    public int Aggregate_Max()
    {
        Student  temp = lobj.get(0);
        int iMax = temp.Marks;

         for(Student sref : lobj)
        {
            if(sref.Marks > iMax)
            {
                iMax = sref.Marks;
        
            }
        
        }

        return iMax;

    }

    // select Min(marks) from student

    public int Aggregate_Min()
    {
        Student  temp = lobj.get(0);
        int iMin = temp.Marks;

         for(Student sref : lobj)
        {
            if(sref.Marks < iMin)
            {
                iMin = sref.Marks;
        
            }
        
        }

        return iMin;

    }

     // select sum of (marks) from student

    public int Aggregate_Sum()
    {
        // Student  temp = lobj.get(0);
        int iSum =0 ;

         for(Student sref : lobj)
        {
           iSum = iSum + sref.Marks;
        
        }

        return iSum;

    }

     // select AVG  (marks) from student

    public float Aggregate_AVG()
    {
        // Student  temp = lobj.get(0);
        int iSum =0 ;

         for(Student sref : lobj)
        {
           iSum = iSum + sref.Marks;
        
        }

        return (iSum/(lobj.size()));

    }


    // delete from studentwhere RNo = 2;

    public void DeleteFrom(int no)
    {
       int i = 0;
        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                lobj.remove(i);
                break;
            }
            i++;
           
            
        }
    }



}

class DataBaseManagementSystem
{
    public static void main(String[] args)
    {
        DBMS obj = new DBMS();
        obj.StartDBMS();

        /* 
        obj.InsertIntoTables("Rahul", 23, 89);
        obj.InsertIntoTables("Sagar", 26, 88);
        obj.InsertIntoTables("Pooja", 20, 56);
        obj.InsertIntoTables("Sayali", 30, 99);
        obj.InsertIntoTables("Tejas", 29, 68);

        obj.SelectFrom();
        obj.SelectFrom(2);
        obj.SelectFrom("Tejas");

        System.out.println("Maximum marks are : " + obj.Aggregate_Max());
        System.out.println("Minimum marks are : " + obj.Aggregate_Min());
        System.out.println("Addition  of  marks are : " + obj.Aggregate_Sum());
        System.out.println("Average of  marks are : " + obj.Aggregate_AVG());

        obj.DeleteFrom(2);
        obj.SelectFrom();
        */


    }
}


// Insert Query
// Insert into Student values Rahul 23 67 
// 0       1     2       3       4   5  6    after tokenization and no of tokens are : 7
// No of tokens : 7



// select query
// select * from student
// 0      1  2     3
// no of tokens : 4

// delete
// delete from student where Rno = 4 
// 0       1     2      3     4   5 6
// no of tokens = 7

// select Max Age from student
// 0        1  2    3     4     

// no of tokens 5


// update 