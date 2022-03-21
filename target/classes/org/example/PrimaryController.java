/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrimaryController{
    ArithmeticAppNew arithmeticApp;
    private String exp = "";
    private int base=16;

    @FXML // fx:id="aBtn"
    private Button aBtn; // Value injected by FXMLLoader

    @FXML // fx:id="bBtn"
    private Button bBtn; // Value injected by FXMLLoader

    @FXML // fx:id="cBtn"
    private Button cBtn; // Value injected by FXMLLoader

    @FXML // fx:id="calculatorTF"
    private TextField calculatorTF; // Value injected by FXMLLoader

    @FXML // fx:id="clearBtn"
    private Button clearBtn; // Value injected by FXMLLoader

    @FXML // fx:id="dBtn"
    private Button dBtn; // Value injected by FXMLLoader

    @FXML // fx:id="didveBtn"
    private Button didveBtn; // Value injected by FXMLLoader

    @FXML // fx:id="eBtn"
    private Button eBtn; // Value injected by FXMLLoader

    @FXML // fx:id="eightBtn"
    private Button eightBtn; // Value injected by FXMLLoader

    @FXML // fx:id="equelBtn"
    private Button equelBtn; // Value injected by FXMLLoader

    @FXML // fx:id="fBtn"
    private Button fBtn; // Value injected by FXMLLoader

    @FXML // fx:id="fiveBtn"
    private Button fiveBtn; // Value injected by FXMLLoader

    @FXML // fx:id="fourBtn"
    private Button fourBtn; // Value injected by FXMLLoader

    @FXML // fx:id="listBox"
    private ComboBox <String> listBox; // Value injected by FXMLLoader

    @FXML // fx:id="minusBtn"
    private Button minusBtn; // Value injected by FXMLLoader

    @FXML // fx:id="mulBtn"
    private Button mulBtn; // Value injected by FXMLLoader

    @FXML // fx:id="nineBth"
    private Button nineBth; // Value injected by FXMLLoader

    @FXML // fx:id="oneBtn"
    private Button oneBtn; // Value injected by FXMLLoader

    @FXML // fx:id="plushBtn"
    private Button plushBtn; // Value injected by FXMLLoader

    @FXML // fx:id="sevenBtn"
    private Button sevenBtn; // Value injected by FXMLLoader

    @FXML // fx:id="sixBtn"
    private Button sixBtn; // Value injected by FXMLLoader

    @FXML // fx:id="threeBtn"
    private Button threeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="twoBtn"
    private Button twoBtn; // Value injected by FXMLLoader

    @FXML // fx:id="zeroBtn"
    private Button zeroBtn; // Value injected by FXMLLoader

    @FXML
    void chooseFromList(ActionEvent event) {
        String chosen = listBox.getSelectionModel().getSelectedItem();
        switch (chosen) {
            case "DEC":
                calculatorTF.setText("");
                exp = "";
                base = 10;
                aBtn.setDisable(true);bBtn.setDisable(true);cBtn.setDisable(true);dBtn.setDisable(true);eBtn.setDisable(true);
                fBtn.setDisable(true);nineBth.setDisable(false);eightBtn.setDisable(false);sevenBtn.setDisable(false);
                sixBtn.setDisable(false);fiveBtn.setDisable(false);fourBtn.setDisable(false);threeBtn.setDisable(false);
                twoBtn.setDisable(false);oneBtn.setDisable(false);zeroBtn.setDisable(false);
                break;
            case "OCT":
                calculatorTF.setText("");
                exp = "";
                base = 8;
                aBtn.setDisable(true);bBtn.setDisable(true);cBtn.setDisable(true);dBtn.setDisable(true);eBtn.setDisable(true);
                fBtn.setDisable(true);nineBth.setDisable(true);eightBtn.setDisable(true);sevenBtn.setDisable(false);
                sixBtn.setDisable(false);fiveBtn.setDisable(false);fourBtn.setDisable(false);threeBtn.setDisable(false);
                twoBtn.setDisable(false);oneBtn.setDisable(false);zeroBtn.setDisable(false);
                break;
            case "BIN":
                calculatorTF.setText("");
                exp = "";
                base = 2;
                aBtn.setDisable(true);bBtn.setDisable(true);cBtn.setDisable(true);dBtn.setDisable(true);eBtn.setDisable(true);
                fBtn.setDisable(true);nineBth.setDisable(true);eightBtn.setDisable(true);sevenBtn.setDisable(true);
                sixBtn.setDisable(true);fiveBtn.setDisable(true);fourBtn.setDisable(true);threeBtn.setDisable(true);
                twoBtn.setDisable(true);oneBtn.setDisable(false);zeroBtn.setDisable(false);
                break;
            case "HAX":
                calculatorTF.setText("");
                exp = "";
                base =16;
                aBtn.setDisable(false);bBtn.setDisable(false);cBtn.setDisable(false);dBtn.setDisable(false);eBtn.setDisable(false);
                fBtn.setDisable(false);nineBth.setDisable(false);eightBtn.setDisable(false);sevenBtn.setDisable(false);
                sixBtn.setDisable(false);fiveBtn.setDisable(false);fourBtn.setDisable(false);threeBtn.setDisable(false);
                twoBtn.setDisable(false);oneBtn.setDisable(false);
        }
    }

    @FXML
    void initialize() {
        assert listBox != null : "fx:id=\"listBox\" was not injected: check your FXML file 'primary.fxml'.";
        listBox.getItems().add("HAX");
        listBox.getItems().add("DEC");
        listBox.getItems().add("OCT");
        listBox.getItems().add("BIN");
        listBox.getSelectionModel().selectFirst();
    }
    @FXML
    void charTostring(ActionEvent event){
        String x;
        x = ((Button)event.getSource()).getText();
        exp +=x;
        calculatorTF.setText(exp);
    }

    @FXML
    void clean(ActionEvent event) {
        calculatorTF.setText("");
        exp = "";
    }

    @FXML
    void cal(ActionEvent event) {
        try {
            exp = ArithmeticAppNew.cal(exp,base);
            calculatorTF.setText(exp);
        }
        catch (Exception e) {
            calculatorTF.setText("Error: trying to divide by 0");
        }
    }
}
class ArithmeticAppNew {
    public static String cal(String exp, int base) {
        try{
            while (exp.indexOf('*') != -1 || exp.indexOf('/') != -1) {   // first we will do  * or /
                if (exp.indexOf('/') == -1 || exp.indexOf('*') != -1 && exp.indexOf('*') < exp.indexOf('/') ) { //do *
                    exp = doOperate(exp, '*', base, exp.indexOf('*'));
                } else {
                    exp = doOperate(exp, '/', base, exp.indexOf('/'));
                }
            }
            while (exp.indexOf('+') != -1 || exp.indexOf('-',1) != -1) {   // first we will do  + or -
                if (exp.charAt(0) == '-') {//if the first number is negative
                    if (exp.indexOf('-', 1) == -1 || exp.indexOf('+') != -1
                            && exp.indexOf('+') < exp.indexOf('-', 1)) {
                        exp = doOperate(exp, '+', base, exp.indexOf('+'));
                    } else
                        exp = doOperate(exp, '-', base, exp.indexOf('-', 1));
                } else {
                    if (exp.indexOf('-') == -1 || exp.indexOf('+') != -1 && exp.indexOf('+') < exp.indexOf('-')) {
                        exp = doOperate(exp, '+', base, exp.indexOf('+'));
                    } else
                        exp = doOperate(exp, '-', base, exp.indexOf('-'));
                }
            }

        }
        catch (Exception e) {
            throw new RuntimeException();
        }
         return exp.toUpperCase();
    }


    public static String doOperate(String exp, char operate, int base, int index) {
        int length = exp.length();
        int beginum1;
        int endnum1 = index - 1;
        int beginum2 = index + 1;
        int endnum2;
        int flag2n = 0;
        String num1, num2;
        while ((exp.charAt(endnum1) == ' ') && (endnum1 > 0)) {    //search for first num
            endnum1--;
        }
        beginum1 = endnum1;
        endnum1++;
        while ((beginum1>0)&&(exp.charAt(beginum1) != '*') && (exp.charAt(beginum1) != '/')
                && (exp.charAt(beginum1) != '-') && (exp.charAt(beginum1) != '+')){
            beginum1--;
        }
        if(beginum1!=0) beginum1++;
        while (exp.charAt(beginum1) == ' ') beginum1++;
        if (beginum1>endnum1) num1 = "";
        else
            num1 = exp.substring(beginum1, endnum1);

        while ((beginum2 < exp.length()) && (exp.charAt(beginum2) == ' ')) {    //search for second num
            beginum2++;
        }
        if (exp.charAt(beginum2) == '-') {
            flag2n = 1;
            beginum2++;
        }
        endnum2 = beginum2;
        while ((endnum2<length) && (exp.charAt(endnum2) != '*') && (exp.charAt(endnum2) != '/')
                && (exp.charAt(endnum2) != '-') && (exp.charAt(endnum2) != '+')) {
            endnum2++;
        }
        if (endnum2 == length)
            num2 = exp.substring(beginum2);
        else {
            endnum2--;
            while (exp.charAt(endnum2) == ' ') endnum2--;
            endnum2++;
            if (beginum2 > endnum2) num2 = "";
            else
                num2 = exp.substring(beginum2, endnum2);
        }
        if (flag2n==1)
            num2 = '-'+num2;
        String newNum = doArithmetic(num1, num2, operate, base);
        String left = "";
        if (beginum1 != 0)
            left = exp.substring(0, beginum1);
        String right = exp.substring(endnum2);
        return left + newNum + right;
    }

    public static String doArithmetic(String num1, String num2, char operate, int base){
        int num1_ = convertToDecimal(num1, base);
        int num2_ = convertToDecimal(num2, base);
        if(operate=='+')  return Integer.toString(num1_+num2_, base);
        if(operate=='*')  return Integer.toString(num1_*num2_, base);
        if(operate=='-')  return Integer.toString(num1_-num2_, base);
        if(operate=='/'){
            if(num2_ == 0)
                throw new RuntimeException();
        }
        return Integer.toString(num1_/num2_, base);
    }

    public static int convertToDecimal(String num, int base) {
        return Integer.parseInt(num, base);
    }
}