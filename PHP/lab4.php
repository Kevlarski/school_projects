<?php
$size = filter_input(INPUT_POST, "size");
$toppings = $_POST['toppings'];

//check to see if there are no toppings
if (empty($toppings)) {
    $topping_count = 0;
} else {
    $topping_count = count($toppings);
}

$total_cost = 0;

switch ($size) {
    case "small":
        $total_cost = (float) 5 + ($topping_count * .5);
        break;
    case "medium":
        $total_cost = (float) 7 + ($topping_count);
        break;
    case "large":
        $total_cost = (float) 9 + ($topping_count * 1.5);
        break;
}
?>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pizza Time!</title>
    </head>
    <body>
        <header><h1>IT'S PIZZA TIME!</h1></header>
        <form action="lab4.php" method="post"> </br></br>
            <h3><label>Sizes:</label></h3>
            <input type="radio" name="size" value="small" checked/>Small ~ $5<br/>
            <input type="radio" name="size" value="medium"/>Medium ~ $7<br/>
            <input type="radio" name="size" value="large"/>Large ~ $9<br/>
            <h3><label>Toppings:</label></h3> 
            <input type="checkbox" name="toppings[]" value ="pepperoni"/>Pepperoni<br/>
            <input type="checkbox" name="toppings[]" value="mushroom"/>Mushrooms<br/>
            <input type="checkbox" name="toppings[]" value="olive"/>Olives<br/>
            <input type="checkbox" name="toppings[]" value="pineapple"/>Pineapple<br/>
            <input type="checkbox" name="toppings[]" value="ham"/>Ham<br/><br/>
            <input type="submit" value="Get Price"/>
        </form>
        <br/><br/>
        <?php
        echo "<h2>Price for a $size pizza with $topping_count toppings: $"
        . number_format($total_cost, 2) . "</h2>";
        echo "<h3> Toppings:</h3>";
        ?>

        <?php foreach ($toppings as $value) : ?>
            <?php echo "<h3>&#9745; " . $value . "</h3>"; ?>
        <?php endforeach; ?>

    </body>
</html>
