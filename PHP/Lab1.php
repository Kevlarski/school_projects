<?php 
    $wage = htmlspecialchars(filter_input(INPUT_GET, 'wage'));
    $hrs_worked = htmlspecialchars(filter_input(INPUT_GET, 'hrs_worked'));
    $tax_rate = htmlspecialchars(filter_input(INPUT_GET, 'tax_rate'));
?>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pay Calculator</title>
    </head>
    <body>
        <form action="Lab1.php" method="get"> 
            <label>Hourly Wage: $</label> 
            <input type="text" name="wage"/></br></br> 
            <label>Hours Worked: $</label> 
            <input type="text" name="hrs_worked"/></br></br>
            <label>Estimated Tax Rate Percentage: </label>
            <input type="text" name="tax_rate"><label>%</label>
            </br></br>
            <input type="submit" value="Submit"/> </br></br>
        </form>
        
        <?php
            if($hrs_worked>40){
            $gross_pay = ($wage*40)+(($hrs_worked-40)*($wage*1.5));
            } else{$gross_pay = ($hrs_worked*$wage);}
            $tax_owed = ($gross_pay*($tax_rate/100));
            $net_pay = ($gross_pay-$tax_owed);
            echo "Gross pay amount: $".number_format($gross_pay,2)."</br>";
            echo "Taxes paid amount: $".number_format($tax_owed,2)."</br>";
            echo "Net pay amount: $".number_format($net_pay,2)."</br>";
        ?>
    </body>
</html>
