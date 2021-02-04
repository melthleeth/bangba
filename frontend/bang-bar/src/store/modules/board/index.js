import mutations from "./mutations.js";
import actions from "./actions.js";
import getters from "./getters.js";

export default {
  namespaced: true,
  state() {
    return {
        lastFetch: null,
      // dummy data
      recipes: [],
      recipe: [
        {
          username: "관리자",
          category: "official",
          img_path: "../../assets/img/cocktails/Long_island_iced_tea.jpg",
          title_kor: "롱 아일랜드 아이스 티",
          title_eng: "long island iced tea",
          content:
            "롱아일랜드 아이스 티는 일반적으로 보드카, 데킬라, 가벼운 럼주, 트리플 섹, 진, 그리고 콜라 스플래시로 만든 알코올 혼합 음료의 한 종류이다. 아이스 티와 같은 황색을 띠고 있다.",
          tags: [
            "진",
            "보드카",
            "화이트 럼",
            "테킬라",
            "트리플 섹",
            "레몬 주스",
            "설탕 시럽",
            "콜라",
            "단 맛",
            "도수 높음",
          ],
          ingredients: [
            "주류/보드카/15/ml",
            "주류/진/15/ml",
            "주류/화이트 럼/15/ml",
            "주류/테킬라/15/ml",
            "주류/트리플 섹/15/ml",
            "재료/레몬 주스/25/ml",
            "재료/설탕 시럽/30/ml",
            "재료/콜라/1/캔",
            "가니쉬/레몬 슬라이스/1/개",
          ],
          recipes: [
            "모든 재료를 얼음으로 채워진 하이볼 글래스에 넣으세요.",
            "부드럽게 저으세요.",
            "레몬 슬라이스로 장식하세요.",
          ],
        },
        {
          username: "방구석 바텐더",
          category: "custom",
          img_path: "../../assets/img/cocktails/tequila_strawberry_shower.jpg",
          title_kor: "테킬라 스트로베리 샤워",
          title_eng: "tequila strawberry shower",
          content:
            "딸기덕후인 제가 딸기를 칵테일로 접목시켜 봤습니다~~! 마가리타 느낌으로 생각해주시면 되는데요, 확실히 딸기가 들어가서 그런지 상큼하고 맛있습니다ㅎㅎ",
          tags: [
            "테킬라",
            "레몬 주스",
            "딸기",
            "토닉 워터",
            "알딸딸",
          ],
          ingredients: [
            "주류/테킬라/20/ml",
            "재료/레몬 주스/10/ml",
            "재료/토닉 워터/40/ml",
            "재료/딸기/3/알",
            "가니쉬/레몬 슬라이스/1/개",
          ],
          recipes: [
            "깨끗이 씻고 꼭지를 딴 딸기를 컵에 넣고 숟가락으로 마구 부셔주세요.",
            "테킬라, 레몬주스를 넣고 1차로 섞어줍니다.",
            "토닉 워터를 붓고 살살 저어줍니다. (기호에 따라 더 넣어주세요.)",
            "레몬 슬라이스로 장식하세요.",
          ],
        },
      ],
    };
  },
  mutations,
  actions,
  getters,
};
