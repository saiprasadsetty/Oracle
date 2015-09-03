/**
 * 
 */
package controller;

/**
 * @author setty
 *
 */
import model.WoodItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class HardwoodSeller 
{
        public static void main(String[] args) 
    {
        // TODO code application logic here
        String s=JOptionPane.showInputDialog("enter the absloute path of the file");
        readInputFile(s);
    }
    
    public static void readInputFile(String inputFilePath)
    {
	        File file = new File(inputFilePath);
                String content=null;
                BufferedReader br=null;
                String buyername=null;
                String address=null;
                String date=null;
                Double[] deltimes=new Double[100];
                int k=0;
                WoodItem w[]=new WoodItem[10];
                String str1;
                double deltime=0.0,price=0.0,feet1=0.0;
		try
                {
		 	br = new BufferedReader(new FileReader(file));

			content= br.readLine();
                        str1=br.readLine();
                        
                        if(!content.equals(null))
                        {
                        
			StringTokenizer st = new StringTokenizer(content, ";");

		        while (st.hasMoreElements())
                        {
                          buyername=st.nextElement().toString();
                          address=st.nextElement().toString();
                          date=st.nextElement().toString();
		        } 
                        
                        }
                        System.out.println(str1);
                        StringTokenizer st1 = new StringTokenizer(str1, ";");
                        String[] itemarray = new String[10];
                        int i=0;
                        while (st1.hasMoreElements())
                        {
                          itemarray[i]=st1.nextToken();
                          i++;
		        }
                        StringTokenizer st2 =null;
                        System.out.println(i);
                        int total=i;
                        String woodname=null;
                        float ft=0;
                        int feet=0;
                        for(k=0;k<total;k++)
                        {
                            String s3=itemarray[k];
                            st2= new StringTokenizer(s3, ":");
                            float dt = 0;
                            float pr = 0;
                                while(st2.hasMoreElements())
                                {
                                      woodname=st2.nextElement().toString();
                                   if(woodname.equals("Cherry"))
                                   {
                                    dt=(float) 5.95;
                                    pr=2.5f;
                                   }
                                   else if(woodname.equals("Curly Maple"))
                                   {
                                        dt=(float)6;
                                        pr=1.5f;
                                   }else if(woodname.equals("Genuine Mahogany"))
                                   {
                                    dt=(float)9.60;
                                    pr=3.0f;
                                   }else if(woodname.equals("Wenge"))
                                   {
                                    dt=(float)22.35;
                                    pr=5f;
                                   }else if(woodname.equals("White Oak"))
                                   {
                                    dt=(float)6.70;
                                    pr=2.3f;
                                   }else if(woodname.equals("Saw Dust"))
                                   {
                                    dt=(float)1.5;
                                    pr=1f;
                                   }
                                   feet=Integer.parseInt(st2.nextElement().toString());
                                   
                                   if(feet>0&&feet<=100)
                                   {
                                   ft=1;
                                   }
                                   else if(feet>100&&feet<=200)
                                   {
                                     ft=2;
                                   }
                                   else if(feet>200&&feet<=300)
                                   {
                                    ft=3;
                                   }
                                   else if(feet>300&&feet<=400)
                                   {
                                    ft=4;
                                   }
                                   else if(feet>400&&feet<=500)
                                   {
                                     ft=5;
                                    }
                                   else if(feet>500&&feet<1000)
                                  {
                                    ft=5.5f;
                                   }
                                 }
                                System.out.println(ft+ " "+pr);
                                 deltime=(double)ft*pr; 
                                 //System.out.println(deltime);
                                 price=(double)feet*dt;
                                 feet1=(double)feet;
                            w[k]=new WoodItem(woodname,deltime,price,feet1);
                        }
                       System.out.println("----------output----------");
                       System.out.println("Buyername"+buyername);
                       System.out.println("address"+address);
                       System.out.println("value of k"+k);
                       double tot=0.0;
                       for(int j=0;j<k;j++)
                       {
                           System.out.println(w[j].getType()+"--------"+w[j].getPrice()+"--------"+w[j].getFeet());
                           deltimes[j]=w[j].getbaseDeliveryTime();
                           tot=tot+w[j].getPrice();
                           
                       }
                       double max=0.0;
                        
        for (int counter = 0; counter < k; counter++)
        {
            if (deltimes[counter] > max)
         {
          max = deltimes[counter];
          
         }

        }  
        System.out.println("estimated deliverytime is" + max);   
        System.out.println("total price of the purchase"+tot);
                }
                catch (IOException e) 
                {
			e.printStackTrace();
		} 
    }
	

	
	/*public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}*/
	
	
}
