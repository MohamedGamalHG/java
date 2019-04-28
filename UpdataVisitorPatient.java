/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projh.Admin;
import projh.ProjH;
import projh.ResidentPatient;
import projh.VisitorPatient;

/**
 *
 * @author Mohamed GH
 */
public class UpdataVisitorPatient extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Text sub = new Text();
       GridPane root = new GridPane() ;
       root.setAlignment(Pos.CENTER);
       root.setHgap(10);
       root.setVgap(10);
       Label found= new Label();
       found.setId("found");
       Label fname = new Label("First Name: ");
       Label lname = new Label("Last Name: ");
       Label id = new Label("ID: ");
       Label age = new Label("Age: ");
       Label addresse = new Label("Addresse: ");
       Label dept = new Label("Deparment: ");
       Label Time= new Label("Time");
       Label disease=new Label("Medication History");
       //Label dname = new Label("Doctor Name");
        Label dfname = new Label("Doctor First Name");
       Label dlname = new Label("Doctor Last Name");
       Label Did = new Label("Doctor id");
       Label username= new Label("user Name");
       Label pass=new Label("Password");
       
       TextField searchn = new TextField();
       TextField fn = new TextField();
        TextField ln = new TextField();
        TextField idn = new TextField();
        TextField agen = new TextField();
        TextField addressen = new TextField();
        TextField deptn = new TextField();
        TextField timen = new TextField();
        TextField diseasen = new TextField();
       
          TextField dfnamen = new TextField();
        TextField dlnamen = new TextField();
        TextField Didn = new TextField();
        TextField usernamen=new TextField();
        TextField passn=new TextField();
        Button submit = new Button("Submit");
        Button back = new Button("Back");
        Button search = new Button("Search");
        
        /*
        CheckBox box1 = new CheckBox("Surgery");
        CheckBox box2 = new CheckBox("the Heart");
        CheckBox box3 = new CheckBox("The belly");
        CheckBox box4 = new CheckBox("Bones");
        */
       RadioButton r1 = new RadioButton("Surgery");
       RadioButton r2 = new RadioButton("the Heart");
       RadioButton r3 = new RadioButton("The belly");
       RadioButton r4 = new RadioButton("Bones");
       
        
        ToggleGroup toggleGroup = new ToggleGroup();

            r1.setToggleGroup(toggleGroup);
            r2.setToggleGroup(toggleGroup);
            r3.setToggleGroup(toggleGroup);
            r4.setToggleGroup(toggleGroup);


       
        
       HBox l=new HBox();
       l.setSpacing(5);
       l.getChildren().addAll(r1,r2,r3,r4);
       
       
      
        root.add(search, 2, 0);
         
       root.add(fname,0,2);
       root.add(lname,0,3);
       root.add(id,0,4);
       root.add(age,0,5);
       root.add(Time,0,6);
       root.add(dept,0,7);
       root.add(disease,0,8);
       root.add(dfname,0,9);
       root.add(dlname,0,10);
       root.add(Did,0,11);
       
       
       //root.add(dname,0,8);
      root.add(searchn,1,0);
       root.add(found, 1, 1);
       root.add(fn,1,2);
       root.add(ln,1,3);
       root.add(idn,1,4);
       root.add(agen,1,5);
       root.add(timen,1,6);
       root.add(l, 1, 7);
       root.add(diseasen,1,8);
       root.add(dfnamen,1,9);
       root.add(dlnamen,1,10);
        root.add(Didn,1,11);
       //root.add(dnamen,1,10);
       root.add(submit,2,13);
       root.add(sub,1,14);
       root.add(back,0,13);
      
       
        
        
        Scene scene = new Scene(root, 600, 650);
        scene.getStylesheets().add(UpdateNewPatient.class.getResource("UpdateNewPatient.css").toExternalForm());
        
        primaryStage.setTitle("Update New Patient");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        VisitorPatient h =new VisitorPatient();
        search.setOnMouseClicked(e->{
        if(!searchn.getText().isEmpty())
         {
              if(isInt(searchn,searchn.getText()))
              {
                    int i = (Integer.parseInt(searchn.getText()));
                  String j =  h.searchPatient(i);
                  if(j == null)
                  {
                      found.setText("Not Found");
                     
                  }
                   else
                  {
                     found.setText(j+"\n"+"Update data");
                  }
              }else
                  found.setText("Error Entered Number");
               
        }
      });
        
        
        sub.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>(){
        
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                sub.setText("");
            }
            
            
            });
            
        
        Admin x=new Admin();
        submit.setOnAction(e->{
            
            if(!fn.getText().isEmpty() &&!ln.getText().isEmpty()&&!idn.getText().isEmpty()&&!agen.getText().isEmpty()&&!timen.getText().isEmpty()&&!diseasen.getText().isEmpty()&&!dfnamen.getText().isEmpty()&&!dlnamen.getText().isEmpty()&&!Didn.getText().isEmpty())
                
        {
            int n = (Integer.parseInt(searchn.getText()));
            VisitorPatient k = new VisitorPatient();
            //int id,String fname,String lname,String addresse,int age,Department dept,double salary,String username,String pass,String time,String spec
          if(isInt(idn,idn.getText())&&isInt(agen,agen.getText())&&isInt(Didn,Didn.getText()))
          {
            int y = Integer.parseInt(idn.getText());
            int i = Integer.parseInt(agen.getText());
            int b=Integer.parseInt(Didn.getText());
           
            String n1 = fn.getText();String n2 = ln.getText();String n3 = addressen.getText();String n4=diseasen.getText();
            String n6 = timen.getText();
            
            //String user, String pass, int id, String fname, String lname, int age, String Mhistory, String Time,String Dfname,String Dlname,int dID,department dept
            
            k.setPass(passn.getText());k.setUserName(usernamen.getText());k.setdID(b);
            k.setDfname(dfnamen.getText());k.setID(y);k.setDlname(dlnamen.getText());k.setAge(i);
            k.setMhistory(diseasen.getText());k.setTime(timen.getText());
            k.setFName(fn.getText());k.setLName(ln.getText());
            k.setDept(ProjH.Surgery);
            //id, fname, lname, addresse, age, dept, salary, username, pass, time, spec
           if(r1.isSelected())
           {
//            x.AddNewDoctor(y,fn.getText(),ln.getText(),addressen.getText(),i,Main.Surgery,j,
//                    emailn.getText(),passn.getText(),timen.getText(),specn.getText());
               
               //x.AddNewDoctor(i, n1, n2, n3, i, Main.Surgery, j, n4, n5, n6, n7);
            x.updateVisitorPatient(n,k);   
           }
           else if(r2.isSelected())
           {
                  k.setPass(passn.getText());k.setUserName(usernamen.getText());k.setdID(b);
            k.setDfname(dfnamen.getText());k.setID(y);k.setDlname(dlnamen.getText());k.setAge(i);
            k.setMhistory(diseasen.getText());k.setTime(timen.getText());
            k.setFName(fn.getText());k.setLName(ln.getText());
            k.setDept(ProjH.the_Heart);
               x.updateVisitorPatient(n,k);
                
           }
           else if(r3.isSelected())
           {
                  k.setPass(passn.getText());k.setUserName(usernamen.getText());k.setdID(b);
            k.setDfname(dfnamen.getText());k.setID(y);k.setDlname(dlnamen.getText());k.setAge(i);
            k.setMhistory(diseasen.getText());k.setTime(timen.getText());
            k.setFName(fn.getText());k.setLName(ln.getText());
            k.setDept(ProjH.the_belly);
               
               x.updateVisitorPatient(n, k);
           }
           else if(r4.isSelected())
           {
                  k.setPass(passn.getText());k.setUserName(usernamen.getText());k.setdID(b);
            k.setDfname(dfnamen.getText());k.setID(y);k.setDlname(dlnamen.getText());k.setAge(i);
            k.setMhistory(diseasen.getText());k.setTime(timen.getText());
            k.setFName(fn.getText());k.setLName(ln.getText());
            k.setDept(ProjH.Bones);
               x.updateVisitorPatient(n,k);
           }
           
           
           
            sub.setText("Done....");
            sub.setFill(Color.RED);
             sub.setFont(new javafx.scene.text.Font(20));
             
             fn.setText(" ");ln.setText(" ");idn.setText("");agen.setText(" ");addressen.setText(" ");dfnamen.setText(" ");dlnamen.setText("");
             timen.setText(" ");diseasen.setText(" ");deptn.setText(" ");Didn.setText("");
             r1.setSelected(false);
             r2.setSelected(false);
             r3.setSelected(false);
             r4.setSelected(false);
          }
          else
          {
               sub.setText("Error Entered Number in TextField");
            sub.setFill(Color.RED);
             sub.setFont(new javafx.scene.text.Font(20));
          
          }
           
        }
            else
            {
                        sub.setText("You are Ignored Field");
                   sub.setFill(Color.RED);
                    sub.setFont(new javafx.scene.text.Font(20));
            }
        
        
    });
        
        
         back.setOnMouseClicked(e->{
            
                new Page_of_Patient().start(primaryStage);
            });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        private boolean isInt(TextField input,String message)
    {
        try{
        int number = Integer.parseInt(input.getText());
        return true;
        }catch(NumberFormatException e)
        {
            return false;
        }
    
    }
    
}
