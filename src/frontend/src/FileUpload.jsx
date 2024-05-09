import React, {useEffect, useState} from 'react';
import axios from "axios";

function FileUpload() {
    const [selectedFiles, setSelectedFiles] = useState([]);

    const imgStyle = {
        width : "150px",
        height : "150px",
        marginLeft : "10px"
    }
    const aa = {
        width: "100%",
        height: "100%"
    }


    const handleFileChange = (e) => {
        setSelectedFiles(e.target.files);
    };


    const handleUpload = () => {
        if (selectedFiles) {
            const formData = new FormData();
            for (let i = 0; i < selectedFiles.length; i++) {
                formData.append(`files`, selectedFiles[i]); // 파일 추가
            }

            // 서버에 formData 전송
            fetch('http://localhost:8080/my-page/insert-reviewImg', {
                method: 'POST',
                body: formData,
            })
                .then(response => response.json())
                .then(data => {
                    console.log('업로드 성공:', data);
                })
                .catch(error => {
                    console.error('업로드 실패:', error);
                });
        } else {
            alert("파일 입력해주세요.");
        }
    };

    return (
        <div>
            <div>
                <input type="file" onChange={handleFileChange} multiple />
                <button onClick={handleUpload}>업로드</button>
            </div>
            <div>
                {/*{data.map((item) => (*/}
                {/*    <div style={imgStyle}>*/}

                {/*        /!*`http://localhost:8080/${item.url}`*!/*/}
                {/*        /!*<img style={aa} src={`http://localhost:8080/${item.imgUrl}`} alt="이미지 시팔"></img>*!/*/}
                {/*        /!*<img style={aa} src={item.imgUrl}> </img>*!/*/}
                {/*    </div>*/}
                {/*    ))}*/}

            </div>
        </div>

    );
}

export default FileUpload;