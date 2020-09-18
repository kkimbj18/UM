import React from "react";

class New extends React.Component {
  handleSubmit = async (event) => {
    event.preventDefault();
    try {
      this.props.history.push("/my_page");
    } catch {
      alert("문제가 생겨스빈다.");
    }
  };

  render() {
    return (
      <div class="App">
        <Header />
        <Nav page={1} />
        <main>
          <Link to="/my_page">
            <h1 className="mypage_title">마이 페이지</h1>
          </Link>

          <div className="myinfo_title">상품 등록</div>

          <form onSubmit={this.handleSubmit}>
            <div className="myinfo_column">
              <label className="myinfo_name">
                상품 이름
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="상품 이름"
                  name="name"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                가격
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="가격"
                  name="price"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                상위 카테고리
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="카테고리"
                  name="category1"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                하위 카테고리
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="카테고리"
                  name="category2"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                썸네일
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="썸네일"
                  name="thumbnail"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                상세 이미지
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="상세 이미지"
                  name="descriptionImage"
                ></input>
              </label>
            </div>
            <input className="Myinfo_btn" type="submit"></input>
          </form>
        </main>
      </div>
    );
  }
}

export default New;
