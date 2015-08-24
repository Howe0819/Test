function validateMissingText(textbox, errorlabel)
{
    var field = document.getElementById(textbox);
    var label = document.getElementById(errorlabel);
    label.innerHTML = "";
    if(field.value == "")
    {
        label.innerHTML = "Missing entry";
        return false;
    }
    else
    {
        return true;
    } 
}


