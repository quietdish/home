import Modal from './Modal';

import { useState } from 'react';
import './News15.css';


function News15() {

    let title = 'React Study';  ////주황색

    // [데이터] 배열 안에 객체를 넣어 각 항목을 관리합니다.
    const [news, setNews] = useState([
        { title: '오늘의 뉴스', likes: 0 },
        { title: '어제의 뉴스', likes: 0 },
        { title: '내일의 뉴스', likes: 0 }
    ]);


    return (

        <div>
            <div className='black-nav'>
                <h3>Blog Header</h3>
                <div className="blog-title">{title}</div>
            </div>

            {/* 2. map() 함수로 반복 렌더링 */}
            {news.map((item, i) => (
                <div className='post-list' key={i}>
                    <h4>
                        {item.title}
                        <span onClick={() => {
                            // 3. 좋아요 로직: 전체 배열을 복사한 뒤, 클릭한 인덱스(i)의 likes만 변경
                            let copy = [...news];
                            copy[i].likes += 1;
                            setNews(copy);
                        }}> ❤</span> {item.likes}
                    </h4>
                    <p>내용 무</p>
                </div>
            ))}
        </div>
    );

    
    
    
    /* 
    let title = 'React Study';

    let [news1, setNews1] = useState('어제의 뉴스');
    let [news2, setNews2] = useState('오늘의 뉴스');
    let [news3, setNews3] = useState('내일의 뉴스');

    let [news, setNews] = useState(['어제의 뉴스', '오늘의 뉴스', '내일의 뉴스']);

    let [likeCount, setLikeCount] = useState(0);

    let [modalFlag, setModalFlag] = useState(false); 

    */





    // return (
    //     <div>
    //         <div className='black-nav'>
    //             <h3>Blog Header</h3>
    //             {/* <div>React Study</div> */}
    //             {/* <div>{title}</div> */}
    //             <div style={{ color: "orange", fontsize: '20px' }}>{title}</div>
    //         </div>

    //         <div className='post-list'>
    //             <h4 onClick={() => {

    //                 //setModalFlag(true);
    //                 //setModalFlag( modalFlag ? false : true );
    //                 setModalFlag(!modalFlag); // !false -> true );
    //                 //재렌더링

    //             }}> {news[0]} <span onClick={(event) => {
    //                 //event.preventDefault();
    //                 event.stopPropagation();
    //                 setLikeCount(likeCount + 1);
    //             }}>❤</span> {likeCount}</h4>
    //             <p>내용자리</p>
    //         </div>

    //         <div className='post-list'>
    //             <h4> {news[1]}
    //                 {/* <span onClick={() => {
    //                     setLikeCount(likeCount + 1);
    //                 }}>❤</span> {likeCount} */}
    //             </h4>
    //             <p>내용자리</p>
    //         </div>

    //         <div className='post-list'>
    //             <h4> {news[2]}
    //             </h4>
    //             <p>내용자리</p>
    //         </div>




    //         {
    //             // modalFlag == true ? <Modal /> : null
    //         }

    //         {
    //             modalFlag && <Modal />
    //         }

    //     </div>
    // )

}

export default News15;
