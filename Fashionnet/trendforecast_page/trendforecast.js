// 1, 2번 페이지 버튼 클릭이벤트(까맣게되기)

document.querySelectorAll(".pagination span a").forEach(btn => {
    btn.addEventListener("click", e => {
        document.querySelectorAll(".pagination span a").forEach(b => b.classList.remove("active"));
    e.target.classList.add("active");
    });
});