<!-- <p><b>Start typing a name in the input field below:</b></p>
<form action="">
    <label for="fname">First name:</label>
    <input type="text" id="fname" name="fname" onkeyup="showHint(this.value)">
</form>
<p>Suggestions: <span id="txtHint"></span></p>
 -->

<!-- <form>
    Select a CD:
    <select name="cds" onchange="showCD(this.value)">
        <option value="">Select a CD:</option>
        <option value="Bob Dylan">Bob Dylan</option>
        <option value="Bee Gees">Bee Gees</option>
        <option value="Cat Stevens">Cat Stevens</option>
    </select>
</form>
<div id="txtHint"><b>CD info will be listed here...</b></div> -->


<?php

$cars = array("Volvo", "BMW", "Toyota");

echo json_encode($cars);

$jsonobj = '{"Peter":35,"Ben":37,"Joe":43}';

$data = json_decode($jsonobj);

echo $data->Peter;
echo $data->Joe;



function my_callback($item)
{
    return strlen($item);
}
// $strings = ["apple", "orange", "banana", "coconut"];

// $lengths = array_map("my_callback", $string);
// print_r($lengths);


function exclaim($str)
{
    return $str . "! ";
}

function ask($str)
{
    return $str . "? ";
}


function printFormatted($str, $format)
{
    // Calling the $format callback function
    echo $format($str);
}

printFormatted("Hello World", "exclaim");

?>

<script>
    function showCD(str) {
        if (str == "") {
            document.getElementById("txtHint").innerHTML = "";
            return;
        }
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("txtHint").innerHTML = this.responseText;
            }
        }
        xmlhttp.open("GET", "getcd.php?q=" + str, true);
        xmlhttp.send();
    }
</script>
