<?php 
    //getting form data
    $first_name = htmlspecialchars(filter_input(INPUT_POST, 'first_name'));
    $last_name = htmlspecialchars(filter_input(INPUT_POST, 'last_name'));
    $gross_inc = htmlspecialchars(filter_input(INPUT_POST, 'gross_inc', FILTER_VALIDATE_INT));
    $deductions= htmlspecialchars(filter_input(INPUT_POST, 'deductions', FILTER_VALIDATE_INT));
    
    $adjusted_inc = number_format(($gross_inc)-($deductions),2);
    
    if($adjusted_inc<=10275){
        if($adjusted_inc===10275){
            $ten = 1027.5;
        }
        else{
            $ten = ($adjusted_inc)*.1;
        }
    }//if <=
    
    if($adjusted_inc>10275){
        if($adjusted_inc<41775){
            $twelve = ($adjusted_inc)*.12;
            $ten = 1027.5;
        }
        else{
            $twelve = 3780;
            $ten = 1027.5;
        }
    }//if >10275
    
    if($adjusted_inc>41775){
        if($adjusted_inc<89075){
            $twentytwo = ($adjusted_inc)*.22;
        }
        else{
            $twentytwo = 10406;
        }
    }//if >41775
    
    if($adjusted_inc>89075){
        if($adjusted_inc<170050){
            $twentyfour = ($adjusted_inc)*.24;
        }
        else{
            $twentyfour = 19434;
        }
    }//if >89075
    
    if($adjusted_inc>170050){
        if($adjusted_inc<215950){
            $thirtytwo = ($adjusted_inc)*.32;
        }
        else{
            $thirtytwo = 14688;
        }
    }//if >170050
    
    if($adjusted_inc>215950){
        if($adjusted_inc<539900){
            $thirtyfive = ($adjusted_inc)*35;
        }
        else{
            $thirtyfive = 113382.5;
        }
    }//if >215950
    
    if($adjusted_inc>=539900){
        $thirtyseven = ($adjusted_inc)*.37;
    }//if >539900
    
    $tax_total = number_format(($ten+$twelve+$twentytwo+$twentyfour+$thirtytwo+
            $thirtyfive+$thirtyseven),2);
    $gross_tax_per = ($tax_total/$gross_inc)*100;
    $adj_tax_per = ($tax_total/$adjusted_inc)*100;
    
    //string variables
    $taxes_owed_str = "Taxes Owed at ";
    $bracket_str = "% Bracket: $";
    $gross_str = "Gross Income: $";
    $deduction_str = "Total Deductions: $";
    $agi_str = "Adjusted Gross Income: $";
    $tax_tot_str = "Total Taxes Owed: $";
?>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pay Calculator</title>
        <style>
            body{font-family: arial;}
        </style>
    </head>
    <body>
        <form action="proj0.php" method="post"> 
            <label>First Name: </label> 
            <input type="text" name="first_name"/>
            <label>&emsp;Last Name: </label> 
            <input type="text" name="last_name"/></br></br>
            <label>Gross Income: </label> 
            <input type="text" name="gross_inc"/></br></br>
            <label>Total Deductions: </label>
            <input type="text" name="deductions">
            </br></br>
            <input type="submit" value="Submit"/> </br></br>
        </form>
        
        
        <?php
            echo "<h2>Tax Calculator Results for $first_name $last_name</h2>";
            echo $gross_str.number_format($gross_inc,2)."<br/>";
            echo $deduction_str.number_format($deductions,2)."<br/>";
            echo $agi_str.$adjusted_inc."<br/>";
            echo $taxes_owed_str."10".$bracket_str.number_format($ten,2)."<br/>";
            echo $taxes_owed_str."12".$bracket_str.number_format($twelve,2)."<br/>";
            echo $taxes_owed_str."22".$bracket_str.number_format($twentytwo,2)."<br/>";
            echo $taxes_owed_str."24".$bracket_str.number_format($twentyfour,2)."<br/>";
            echo $taxes_owed_str."32".$bracket_str.number_format($thirtytwo,2)."<br/>";
            echo $taxes_owed_str."35".$bracket_str.number_format($thirtyfive,2)."<br/>";
            echo $taxes_owed_str."37".$bracket_str.number_format($thirtyseven,2)."<br/>";
            echo $tax_tot_str.$tax_total."<br/>";
            echo "Taxes owed as percentage of gross income: ".$gross_tax_per."%<br/>";
            echo "Taxes Owed as percentage of adjusted gross income: ".$adj_tax_per."%<br/>";
        ?>
    </body>
</html>
