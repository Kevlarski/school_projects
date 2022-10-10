<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>DB Happy Fun Times</title>
        <style>
            table{border-collapse: collapse;}
            th,td{padding:3px;}
            hr{float:left;}
            h3{margin-bottom: 5px;}
            a{font-weight: bold;
        text-decoration: none;}
        </style>
    </head>
    <body>
        
        <?php include 'topNav.php';?>
        <br/>
        <!-- Stocks Table -->
        <table border="2px">
            <caption style="caption-side:top"><h3>Stocks</h3></caption>
            <tr>
                <th>Symbol</th>
                <th>Name</th>
                <th>Current Price</th>
                <th>ID</th>
            </tr>
            <?php foreach ($stocks as $stock) : ?> 
                <tr>
                    <td><?php echo $stock['symbol'] ?></td>
                    <td><?php echo $stock['stk_name'] ?></td>
                    <td><?php echo "$". number_format($stock['current_price'],4) ?></td>
                    <td><?php echo $stock['id'] ?></td>
                </tr>
            <?php endforeach; ?>
        </table>
        <br/>
        <!-- Stock Change Form -->
        <h3>&emsp;Add Stock</h3>
        <hr width="75%"/>
        <form action="stocks.php" method="post"> <br/><br/>
            <label>Stock Name: </label> 
            <input type="text" name="stk_name"/>
            <label>&emsp;Symbol: </label> 
            <input type="text" name="symbol"/>
            <label>&emsp;Current Price: </label> 
            <input type="text" name="current_price"/>
            <input type="hidden" name="stk_action" value="add"><label>&emsp;</label>
            <input type="submit" value="Add Stock"/> <br/><br/>
        </form>

        <h3>&emsp;Update Stock Price</h3>
        <hr width="75%"/>
        <form action="stocks.php" method="post"> </br></br>
            <label>Stock Name: </label> 
            <input type="text" name="name"/>
            <label>&emsp;Symbol: </label> 
            <input type="text" name="symbol"/>
            <label>&emsp;Current Price: </label> 
            <input type="text" name="current_price"/>
            <input type="hidden" name="stk_action" value="update"><label>&emsp;</label>
            <input type="submit" value="Update Stock"/> </br></br>
        </form>

        <h3>&emsp;Delete Stock</h3>
        <hr width="75%"/>
        <form action="stocks.php" method="post"> </br></br>
            <label>Symbol: </label> 
            <input type="text" name="symbol"/>
            <input type="hidden" name="stk_action" value="delete"><label>&emsp;</label>
            <input type="submit" value="Submit"/> </br></br>
        </form>
    </body>
</html>