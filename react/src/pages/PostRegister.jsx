import { useRef, useState } from "react";
import "../csss/PostRegister.css";

const categoryList = [
    "생활/가전",
    "IT기기",
    "낚시용품",
    "의류",
    "가구",
    "도서",
    "반려용품",
    "운동용품",
    "기타",
];

export default function PostRegister() {

    const fileInputRef = useRef(null);

    const [ images, setImages ] = useState([]);

    const [ title, setTitle ] = useState("");

    const [ tradeType, setTradeType ] = useState("used");

    const [ price, setPrice ] = useState("");

    const [ auctionPrice, setAuctionPrice ] = useState("");

    const [ category, setCategory ] = useState("");

    const [ condition, setCondition ] = useState("");

    const [ description, setDescription ] = useState("");

    const [ location, setLocation ] = useState("");

    const [ shipping, setShipping ] = useState(false);

    const [ suggestPrice, setSuggestPrice ] = useState(false);

    const [ bidUnit, setBidUnit ] = useState("1000");

    const [ auctionDay, setAuctionDay ] = useState("3");



    const handleImageClick = () => {

        fileInputRef.current.click();

    };



    const handleImageUpload = (e) => {

        const files = Array.from(e.target.files);

        if (images.length + files.length > 10) {

            alert("이미지는 최대 10장까지 가능합니다.");

            return;

        }

        const preview = files.map(file => URL.createObjectURL(file));

        setImages(prev => [ ...prev, ...preview ]);

        e.target.value = "";

    };



    const removeImage = (index) => {

        URL.revokeObjectURL(images[ index ]);

        setImages(images.filter((_, i) => i !== index));

    };



    const handleSubmit = (e) => {

        e.preventDefault();

        if (title.trim() === "") {

            alert("물품명을 입력하세요.");

            return;

        }

        if (category === "") {

            alert("카테고리를 선택하세요.");

            return;

        }

        alert("등록 완료");

    };



    return (

        <div className="register-container">

            <div className="register-card">

                <h2 className="register-title">

                    물품 등록

                </h2>

                <p className="register-notice">

                    <span className="required">*</span>
                    필수 입력 항목입니다.

                </p>

                <form onSubmit={handleSubmit}>


                    <div className="form-group">

                        <label className="form-label">

                            상품 이미지

                            <span className="required">*</span>

                        </label>

                        <input
                            type="file"
                            multiple
                            accept="image/*"
                            ref={fileInputRef}
                            onChange={handleImageUpload}
                            hidden
                        />

                        <div className="image-list-wrapper">

                            <div
                                className="image-upload-box"
                                onClick={handleImageClick}
                            >

                                +<br />

                                이미지 추가

                            </div>

                            {

                                images.map((img, index) => (

                                    <div
                                        key={index}
                                        className="preview-image-container"
                                    >

                                        <img
                                            src={img}
                                            className="preview-image"
                                        />

                                        <button
                                            type="button"
                                            className="image-delete-btn"
                                            onClick={() => removeImage(index)}
                                        >

                                            ×

                                        </button>

                                    </div>

                                ))

                            }

                        </div>

                    </div>




                    {/* 물품명 */}

                    <div className="form-group">

                        <label className="form-label">
                            물품명
                            <span className="required">*</span>
                        </label>

                        <input
                            type="text"
                            className="form-input"
                            placeholder="상품명을 입력하세요."
                            maxLength={60}
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />

                        <div className="char-count">
                            {title.length} / 60
                        </div>

                    </div>



                    {/* 거래방식 */}

                    <div className="form-group">

                        <label className="form-label">

                            거래 방식

                        </label>

                        <div className="button-group">

                            <button
                                type="button"
                                className={`btn-trade ${tradeType === "used" ? "active" : ""}`}
                                onClick={() => setTradeType("used")}
                            >
                                일반 중고거래
                            </button>

                            <button
                                type="button"
                                className={`btn-trade ${tradeType === "auction" ? "active" : ""}`}
                                onClick={() => setTradeType("auction")}
                            >
                                경매
                            </button>

                        </div>

                    </div>



                    {/* 가격 */}

                    {

                        tradeType === "used"

                            ?

                            <div className="form-group">

                                <label className="form-label">

                                    판매 가격

                                </label>

                                <div className="price-input-wrapper">

                                    <input
                                        type="number"
                                        className="form-input price-input"
                                        placeholder="판매가격"
                                        value={price}
                                        onChange={(e) => setPrice(e.target.value)}
                                    />

                                    <span className="price-unit">

                                        원

                                    </span>

                                </div>

                                <label className="checkbox-label">

                                    <input
                                        type="checkbox"
                                        checked={suggestPrice}
                                        onChange={(e) => setSuggestPrice(e.target.checked)}
                                    />

                                    가격 제안 허용

                                </label>

                            </div>

                            :

                            <div className="auction-grid">

                                <div>

                                    <label className="form-label">

                                        시작 가격

                                    </label>

                                    <div className="price-input-wrapper">

                                        <input
                                            type="number"
                                            className="form-input price-input"
                                            placeholder="경매 시작가"
                                            value={auctionPrice}
                                            onChange={(e) => setAuctionPrice(e.target.value)}
                                        />

                                        <span className="price-unit">

                                            원

                                        </span>

                                    </div>

                                </div>

                                <div>

                                    <label className="form-label">

                                        입찰 단위

                                    </label>

                                    <select
                                        className="form-input"
                                        value={bidUnit}
                                        onChange={(e) => setBidUnit(e.target.value)}
                                    >

                                        <option value="1000">1,000원</option>
                                        <option value="5000">5,000원</option>
                                        <option value="10000">10,000원</option>
                                        <option value="50000">50,000원</option>

                                    </select>

                                </div>

                                <div>

                                    <label className="form-label">

                                        경매 기간

                                    </label>

                                    <select
                                        className="form-input"
                                        value={auctionDay}
                                        onChange={(e) => setAuctionDay(e.target.value)}
                                    >

                                        <option value="1">1일</option>
                                        <option value="3">3일</option>
                                        <option value="5">5일</option>
                                        <option value="7">7일</option>

                                    </select>

                                </div>

                            </div>

                    }



                    {/* 카테고리 */}

                    <div className="form-group">

                        <label className="form-label">

                            카테고리

                            <span className="required">*</span>

                        </label>

                        <select
                            className="form-input"
                            value={category}
                            onChange={(e) => setCategory(e.target.value)}
                        >

                            <option value="">

                                카테고리를 선택하세요.

                            </option>

                            {

                                categoryList.map(item => (

                                    <option
                                        key={item}
                                        value={item}
                                    >

                                        {item}

                                    </option>

                                ))

                            }

                        </select>

                    </div>





                    {/* 상품 상태 */}

                    <div className="form-group">

                        <label className="form-label">
                            상품 상태
                        </label>

                        <select
                            className="form-input"
                            value={condition}
                            onChange={(e) => setCondition(e.target.value)}
                        >
                            <option value="">선택하세요.</option>
                            <option value="new">새상품</option>
                            <option value="like-new">거의 새상품</option>
                            <option value="good">사용감 적음</option>
                            <option value="used">사용감 많음</option>
                        </select>

                    </div>



                    {/* 상세 설명 */}

                    <div className="form-group">

                        <label className="form-label">

                            상품 설명

                        </label>

                        <textarea
                            className="form-input"
                            rows={8}
                            placeholder="상품 상태, 구성품, 구매 시기 등을 입력하세요."
                            value={description}
                            onChange={(e) => setDescription(e.target.value)}
                        />

                    </div>



                    {/* 거래 지역 */}

                    <div className="form-group">

                        <label className="form-label">

                            거래 지역

                        </label>

                        <input
                            type="text"
                            className="form-input"
                            placeholder="예) 서울 강남구"
                            value={location}
                            onChange={(e) => setLocation(e.target.value)}
                        />

                    </div>



                    {/* 택배 여부 */}

                    <div className="form-group">

                        <label className="checkbox-label">

                            <input
                                type="checkbox"
                                checked={shipping}
                                onChange={(e) => setShipping(e.target.checked)}
                            />

                            택배 거래 가능

                        </label>

                    </div>



                    {/* 버튼 */}

                    <div className="form-actions">

                        <button
                            type="button"
                            className="btn-cancel"
                        >
                            취소
                        </button>

                        <button
                            type="submit"
                            className="btn-submit"
                        >
                            {tradeType === "used"
                                ? "중고 등록"
                                : "경매 등록"}
                        </button>

                    </div>

                </form>

            </div>

        </div>

    );

}                                        