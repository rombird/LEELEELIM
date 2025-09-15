const etcRadio = document.querySelectorAll(".etcRadio");


etcRadio.forEach(radio => {
    const etcInput = radio.closest("label").querySelector(".etcInput");
    radio.addEventListener("change", () => {
        etcInput.disabled = !radio.checked;     // radio버튼이 체크되어있지않다면 input은 비활성화
        if(radio.checked) etcInput.focus();     // 만약 radio버튼이 체크된다면 input은 활성화
    });
});