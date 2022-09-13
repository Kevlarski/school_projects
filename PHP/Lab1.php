<?php 
    $wage = htmlspecialchars(filter_input(INPUT_GET, 'wage'));
    $hrs_worked = htmlspecialchars(filter_input(INPUT_GET, 'hrs_worked'));
    $tax_rate = htmlspecialchars(filter_input(INPUT_GET, 'tax_rate'));
    
    if($hrs_worked>40){
        $gross = ($wage*40)+(($hrs_worked-40)*($wage*1.5));
        } 
    else{$gross = $hrs_worked*$wage;}
    
    $tax_owed = ($gross*($tax_rate/100));
    $net_pay = ($gross-$tax_owed);
?>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pay Calculator</title>
    </head>
    <body>
        <form action="Lab1.php" method="get"> 
            <label>Hourly Wage: </label> 
            <input type="text" name="wage"/></br></br> 
            <label>Hours Worked: </label> 
            <input type="text" name="hrs_worked"/></br></br>
            <label>Estimated Tax Rate Percentage: </label>
            <input type="text" name="tax_rate">
            </br></br>
            <input type="submit" value="Submit"/> </br></br>
        </form>
        
        <?php
            echo "Gross pay amount: $gross</br>";
            echo "Taxes paid amount: $tax_owed</br>";
            echo "Net pay amount: $net_pay</br>";
        ?>
    </body>
</html>
