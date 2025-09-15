const etcRadio = document.getElementById("etc");
const etcInput = document.querySelector(".etc-input");

etcRadio.addEventListener("change", () => {
    if(etcRadio.checked){
        etcInput.disabled = false;
        etcInput.focus();
        
    }else{
        etcInput.disabled = true;
    }
});