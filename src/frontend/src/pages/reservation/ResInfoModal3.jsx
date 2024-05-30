import { useEffect } from "react";
import "../../styles/resInfoModal3.css"


const ResInfoModal3 = ({act3, setAct3}) => {

  useEffect(() => {
    if (act3) {
      document.body.style.overflow = 'hidden'; // 팝업이 활성화되면 스크롤을 막습니다.
    } else {
      document.body.style.overflow = 'auto'; // 팝업이 비활성화되면 스크롤을 허용합니다.
    }

    // 컴포넌트가 언마운트될 때 스크롤을 다시 활성화하도록 정리합니다.
    return () => {
      document.body.style.overflow = 'auto';
    };
  }, [act3]); 

  const handleClose = () => {
    setAct3(false);
  }

  return (
    <div className="resInfoModal3Div" style={act3 ? { display: "flex" } : { display: "none" }} onClick={handleClose}>
      <div onClick={(e) => e.stopPropagation()}>
        <div style={{ display: "flex", justifyContent: "flex-end" }}><button onClick={handleClose} style={{ border: "none", backgroundColor: "transparent", fontSize: "25px", width: "30px", height: "30px" }}>&times;</button></div>
        <div>
          <h1 className="modalName">개인정보 국외 이전 동의 (필수)</h1>
          <hr style={{color:"black"}}/>
          <div className="img-div">
            <img className="modalInImg" src="https://media.discordapp.net/attachments/1232689740793253968/1243448771921317928/image.png?ex=66518369&is=665031e9&hm=5be4b8ae4f617237d4cb38782830596dfbf2bfa057e9e5094cfede33aa52e197&=&format=webp&quality=lossless&width=1798&height=842" alt=""/>
          </div>
        </div>
      </div>
    </div>
  )
 }
export default ResInfoModal3;