document.addEventListener("DOMContentLoaded", function() {
    const uploadArea = document.getElementById("upload");
    const fileInput = document.getElementById("fileUpload");

    let uploadedFiles = [];

    // 파일 확장자 제한
    const allowedExtensions = ['xlsx', 'pptx', 'txt', 'pdf', 'jpg', 'jpeg', 'png', 'hwp'];
    const maxCount = 5;
    const maxSize = 6 * 1024 * 1024; // 6MB


    // 드래그 시 시각효과
    uploadArea.addEventListener("dragover", (e) => {
        e.preventDefault();
        uploadArea.classList.add("dragover");
    });

    // 드래그 해온 거 빠지면 dragover 시각효과 없어짐
    uploadArea.addEventListener("dragleave", () => {
        uploadArea.classList.remove("dragover");
    });

    // 파일 드롭 시 처리
    uploadArea.addEventListener("drop", (e) => {
        e.preventDefault();
        uploadArea.classList.remove("dragover");
        handleFiles(e.dataTransfer.files);
    });

    // 파일 선택 버튼 이용 시 처리
    fileInput.addEventListener("change", (e) => {
        handleFiles(e.target.files);
    });


    // ================================
    // 파일 처리 함수
    // ================================

    function handleFiles(files){
        for (let file of files){
            const ext = file.name.split('.').pop().toLowerCase();

            // upload한 파일의 확장자가 아니라면
            if(!allowedExtensions.includes(ext)){
                alert(`${file.name}: 지원하지 않는 형식입니다.`);
                continue;
            }

            // upload한 파일 숫자가 5가 넘어간다면
            if(uploadedFiles.length >= maxCount){
                alert("최대 5개까지 업로드 할 수 있습니다.");
                break;
            }
            // file 사이즈가 6MB를 넘어간다면
            if(file.size > maxSize){
                alert(`${file.name} : 6MB 초과`);
                continue;
            }

            // 이미 같은 일음의 파일이 있으면 건너뛰기
            if(uploadedFiles.some(f => f.name === file.name)){
                alert(`${file.name}은 이미 업로드되어있습니다.`);
                continue;
            }

            uploadedFiles.push(file);
            showPreview(file);
        }

        // 파일 input 초기화(같은 파일 다시 선택할 때 문제 방지)
        fileInput.value = "";
    }

    // 미리보기 표시
    function showPreview(file){
        // previewContainer가 이미 있는 지 확인
        let previewContainer = uploadArea.querySelector(".preview-container");

        // previewContainer가 없다면 새로 생성
        if(!previewContainer){
            previewContainer = document.createElement("div");
            previewContainer.className = "preview-container";
            
            // 안내문 제거(드래그 해서 파일업로드 가능)
            const placeholder = uploadArea.querySelector("p");
            if(placeholder) placeholder.remove();
            
            uploadArea.appendChild(previewContainer);
        }
        
        if(previewContainer.children.length > 0){
            const line = document.createElement("div");
            line.className = "line-dotted-preview";
            previewContainer.appendChild(line);
        }

        // preview-box 생성
        const previewBox = document.createElement("div");
        previewBox.className = "preview-box";
        
        const previewBoxIn = document.createElement("div");

        const fileName = document.createElement("div");
        fileName.className = "file-name";
        fileName.textContent = file.name;

        const fileSize = document.createElement("div");
        fileSize.className = "file-size"
        fileSize.textContent = formatBytes(file.size);

        previewBoxIn.appendChild(fileName);
        previewBoxIn.appendChild(fileSize);

        // previewBox.appendChild(previewBoxIn);

        const deleteBtn = document.createElement("button");
        deleteBtn.className = "delete-btn";
        deleteBtn.type = "button";
        deleteBtn.innerHTML = '<i class="fa-solid fa-trash fa-lg"></i>';

        // 삭제버튼 누르면 삭제이벤트
        deleteBtn.addEventListener("click", () => {
            uploadedFiles = uploadedFiles.filter(f => !(f.name === file.name && f.size === file.size));
            
            const prevLine = previewBox.previousElementSibling;
            if(prevLine && prevLine.classList.contains("line-dotted-preview")){
                prevLine.remove();
            }
            previewBox.remove();

            // 업로드 된 파일이 없다면 안내문(파일 드래그 가능) 다시 표시
            if(uploadedFiles.length === 0){
                previewContainer.remove();
                showPlaceholder();
            }
        });

        

        previewBox.appendChild(previewBoxIn);
        previewBox.appendChild(deleteBtn);
        previewContainer.appendChild(previewBox)
    }

    // 파일 크기 표시 함수
    function formatBytes(bytes) {
        if (bytes === 0) return '0 Bytes';
        const k = 1024;
        const sizes = ['Bytes', 'KB', 'MB', 'GB'];
        const i = Math.floor(Math.log(bytes) / Math.log(k));
        return parseFloat((bytes / Math.pow(k, i)).toFixed(1)) + sizes[i];
    }

    // 안내문 다시 표시
    function showPlaceholder(){
        const p = document.createElement("p");
        p.textContent = "파일을 드래그하여 첨부할 수 있습니다";
        uploadArea.prepend(p);
    }


    // document.querySelector('form').addEventListener('submit', function(e){
    //     e.preventDefault();
    //     const formData = new FormData();
    //     uploadedFiles.forEach(f => formData.append('fileUpload',f));

    // });

});
