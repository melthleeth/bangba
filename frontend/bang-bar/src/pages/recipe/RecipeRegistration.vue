<template>
  <div class="font-S-CoreDream-light flex flex-col justify-items-center mx-16">
    <span class="text-4xl text-center my-10 font-S-CoreDream-medium font-bold"
      >{{ category }} 레시피 등록</span
    >
    <base-card class="w-2/3" id="card-margin">
      <form
        class="text-lg flex flex-col justify-items-start mx-4"
        id="form-recipe"
        @submit.prevent=""
      >
        <div
          class="form-control flex flex-col items-center"
          :class="{ invalid: !img_path.isValid }"
        >
          <img
            class="w-64 h-96 rounded-3xl object-cover"
            :src="img_path.val"
            alt="cocktail image"
          />
          <input
            class="w-1/3 text-sm mt-2"
            type="text"
            id="imgsrc"
            placeholder="이미지 주소 입력"
            v-model.trim="imgsrc"
          />
          <base-button
            class="mt-4 px-4 py-2 text-base"
            @click="showImgRegDialog"
            >사진 등록</base-button
          >
          <p v-if="!img_path.isValid">등록된 사진이 없습니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !title_kor.isValid }">
          <label for="title_kor">칵테일 이름</label>
          <input
            class="w-1/3"
            type="text"
            id="title_kor"
            placeholder="칵테일 이름을 정해주세요"
            v-model.trim="title_kor.val"
            @blur="clearValidity('title_kor')"
          />
          <p v-if="!title_kor.isValid">칵테일 이름을 적어주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !title_eng.isValid }">
          <label for="title_eng.val">칵테일 이름 (eng)</label>
          <input
            class="w-1/3"
            type="text"
            id="title_eng"
            placeholder="칵테일 영문명을 적어주세요"
            v-model.trim="title_eng.val"
            @blur="clearValidity('title_eng')"
          />
          <p v-if="!title_eng.isValid">칵테일 영문명을 적어주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !abv.isValid }">
          <label for="abv.val">칵테일 도수 (ABV)</label>
          <input
            class="w-28"
            type="number"
            id="abv"
            placeholder="22"
            v-model.number="abv.val"
            @blur="clearValidity('abv')"
          />
          <p v-if="!abv.isValid">칵테일 도수를 적어주세요.</p>
        </div>
        <div
          class="form-control flex flex-row items-center"
          :class="{ invalid: !content.isValid }"
        >
          <label for="content">칵테일 소개</label>
          <textarea
            class="w-2/3"
            id="content"
            rows="3"
            placeholder="어떤 칵테일인지 소개 해주세요"
            v-model.trim="content.val"
            @blur="clearValidity('content')"
          ></textarea>
          <p v-if="!content.isValid">칵테일 소개는 비어있으면 안됩니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !cupinfo.isValid }">
          <label for="cupinfo">컵 정보 추가하기</label>
          <select
            class="w-4/12"
            name="cupinfo"
            id="cupinfo"
            v-model="cupinfo.val"
            @blur="clearValidity('cupinfo')"
          >
            <option v-for="cup in cups" :key="cup.index" :value="cup.index">{{
              cup.val
            }}</option>
          </select>
          <p v-if="!cupinfo.isValid">컵을 선택해주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !tags.isValid }">
          <label for="tag">태그</label>
          <input
            class="w-3/12"
            type="text"
            id="tag"
            v-model.trim="tag"
            @blur="clearValidity('tags')"
          />
          <base-button class="px-4 py-2" @click="addTag">추가하기</base-button>
          <section class="mt-2">
            <span class="mr-4" v-for="(tag, index) in tags.val" :key="tag">
              {{ tag }}
              <span
                class="ml-2 text-grey-400 cursor-pointer hover:text-red-400"
                @click="removeTag(index)"
                >x</span
              >
            </span>
          </section>
          <p v-if="!tags.isValid">최소 하나의 태그를 추가해주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !ingredients.isValid }">
          <label for="ingredients">재료 추가하기</label>
          <select class="w-28" name="type" id="type" v-model="type">
            <option value="">분류</option>
            <option value="주류">주류</option>
            <option value="재료">재료</option>
            <option value="가니쉬">가니쉬</option>
          </select>
          <input
            class="w-3/12"
            type="text"
            id="ingredient"
            placeholder="보드카"
            v-model.trim="ingredient"
          />
          <input
            class="w-28"
            type="number"
            id="quantity"
            placeholder="30"
            v-model.number="quantity"
          />
          <input
            class="w-28"
            type="text"
            id="unit"
            placeholder="ml"
            v-model.trim="unit"
          />
          <base-button class="px-4 py-2" @click="addIngredient"
            >추가하기</base-button
          >
          <ul>
            <li v-for="(alcoholItem, index) in alcoholTemp" :key="alcoholItem">
              <span class="ml-2">🍸 {{ alcoholItem }}</span>
              <span
                class="ml-2 text-grey-400 cursor-pointer hover:text-red-400"
                @click="removeAlcohol(index)"
                >x</span
              >
            </li>
          </ul>
          <ul>
            <li
              v-for="(ingredientItem, index) in ingredientTemp"
              :key="ingredientItem"
            >
              <span class="ml-2">🥄 {{ ingredientItem }}</span>
              <span
                class="ml-2 text-grey-400 cursor-pointer hover:text-red-400"
                @click="removeIngredient(index)"
                >x</span
              >
            </li>
          </ul>
          <p v-if="!ingredients.isValid || !alcohols.isValid">
            최소 한 가지의 주류, 재료를 추가해주세요.
          </p>
        </div>
        <div class="form-control" :class="{ invalid: !recipes.isValid }">
          <label for="recipes">레시피 추가하기</label>
          <input
            class="w-1/3 text-left"
            type="text"
            id="recipe"
            placeholder="레시피를 입력하세요"
            v-model.trim="recipe"
            @blur="clearValidity('recipes')"
          />
          <base-button class="px-4 py-2" @click="addRecipe"
            >추가하기</base-button
          >
          <ul>
            <li v-for="(recipeItem, index) in recipes.val" :key="recipeItem">
              <span>{{ index + 1 }}. {{ recipeItem }}</span>
              <span
                class="ml-2 text-grey-400 cursor-pointer hover:text-red-400"
                @click="removeRecipe(index)"
                >x</span
              >
            </li>
          </ul>
          <p v-if="!recipes.isValid">최소 한 가지 순서를 추가해주세요.</p>
        </div>
        <section
          class="flex flex-col text-center justify-items-center items-center"
        >
          <span class="font-red" v-if="!formIsValid">
            비어있는 칸이 있습니다. 채운 후 다시 시도해주세요.
          </span>
          <base-button
            mode="important"
            class="w-max px-4 py-2"
            @click="submitForm"
            >레시피 등록하기</base-button
          >
        </section>
      </form>
    </base-card>
  </div>
</template>

<script>
export default {
  props: {
    category: {
      type: String,
      required: true,
      default: "official",
    },
  },
  data() {
    return {
      formIsValid: true,
      isLoading: false,
      error: null,
      cups: [
        { index: 0, name: "none", val: "없음" },
        { index: 1, name: "highball", val: "하이볼 글라스" },
        { index: 2, name: "sling", val: "슬링 글라스" },
        { index: 3, name: "shot", val: "샷 글라스" },
        { index: 4, name: "straight", val: "스트레이트 글라스" },
        { index: 5, name: "pint", val: "파인트" },
        { index: 6, name: "rock", val: "락 글라스" },
        { index: 7, name: "collins", val: "콜린스 글라스" },
        { index: 8, name: "oldfashioned", val: "올드패션드/락 글라스" },
        { index: 9, name: "martini", val: "마티니 글라스" },
        { index: 10, name: "pilsner", val: "필스너 글라스" },
        {
          index: 11,
          name: "irish-coffee-fizz",
          val: "아이리쉬 커피/피즈 글라스",
        },
        { index: 12, name: "brandy-sniffer", val: "브랜디 스니퍼" },
        { index: 13, name: "punch-cup", val: "펀치 컵" },
        { index: 14, name: "cordial", val: "코디얼 글라스" },
        { index: 15, name: "sour", val: "소어 글라스" },
        { index: 16, name: "parfait", val: "파르페 글라스" },
        { index: 17, name: "sherry", val: "쉐리 글라스" },
        { index: 18, name: "champagne-flute", val: "샴페인 플룻" },
        { index: 19, name: "champagne-saucer", val: "샴페인 소서 (쿱)" },
        { index: 20, name: "red-wine", val: "레드 와인 글라스" },
        { index: 21, name: "white-wine", val: "화이트 와인 글라스" },
        { index: 22, name: "margarita", val: "마가리타 글라스" },
        { index: 23, name: "cocktail", val: "칵테일 글라스" },
      ],
      units: [{}],
      tag: "",
      type: "",
      ingredient: "",
      quantity: null,
      unit: "",
      recipe: "",
      alcoholTemp: [],
      ingredientTemp: [],
      imgsrc: "",
      img_path: {
        val: require("../../assets/img/defaultCocktailImage.png"),
        src: "img/defaultCocktailImage.png",
        isValid: true,
      },
      title_kor: {
        val: "",
        isValid: true,
      },
      title_eng: {
        val: "",
        isValid: true,
      },
      abv: {
        val: null,
        isValid: true,
      },
      content: {
        val: "",
        isValid: true,
      },
      cupinfo: {
        val: "",
        isValid: true,
      },
      tags: {
        val: [],
        isValid: true,
      },
      alcohols: {
        val: [],
        isValid: true,
      },
      ingredients: {
        val: [],
        isValid: true,
      },
      recipes: {
        val: [],
        isValid: true,
      },
    };
  },
  methods: {
    showImgRegDialog() {
      // console.log("사진 등록 중");
      // console.log(this.img_path.val);
      this.img_path.val = this.imgsrc;
      this.imgsrc = "";
      // alert("사진 등록 기능 준비중");
    },
    addTag() {
      if (this.tag === "") alert("태그 내용을 입력해주세요.");
      else if (this.tags.val.includes(this.tag))
        alert("이미 등록된 태그입니다.");
      else {
        this.tags.val.push(this.tag);
        this.tag = "";
      }
    },
    removeTag(index) {
      this.tags.val.splice(index, 1);
    },
    addIngredient() {
      if (this.type === "") {
        alert("분류를 선택해주세요.");
        return;
      }
      if (this.ingredient === "") {
        alert("재료명을 입력해주세요.");
        return;
      }
      if (!this.quantity || this.quantity <= 0) {
        alert("용량을 입력해주세요. (용량은 0보다 커야 합니다.");
        return;
      }
      if (this.unit === "") {
        alert("단위를 입력해주세요.");
        return;
      }

      const isAlcoholDuplicated = this.alcoholTemp.filter((alcohol) => {
        if (alcohol.includes(this.ingredient)) return true;
        return false;
      });
      const isIngredientDuplicated = this.ingredientTemp.filter(
        (ingredient) => {
          if (ingredient.includes(this.ingredient)) return true;
          return false;
        }
      );

      if (!isAlcoholDuplicated || !isIngredientDuplicated) {
        alert("이미 등록된 재료입니다.");
        return;
      }

      const tempItem = `${this.ingredient} ${this.quantity}${this.unit}`;

      if (this.type === "주류") {
        const alcoholItem = `${this.ingredient}/${this.quantity}/${this.unit}`;
        this.alcoholTemp.push(tempItem);
        this.alcohols.val.push(alcoholItem);
        this.alcohols.isValid = true;
      } else {
        const ingredientItem = `${this.type}/${this.ingredient}/${this.quantity}/${this.unit}`;
        this.ingredientTemp.push(tempItem);
        this.ingredients.val.push(ingredientItem);
        this.ingredients.isValid = true;
      }
      alert(this.type + " (" + this.ingredient + ")가 추가되었습니다.");

      this.type = "";
      this.ingredient = "";
      this.quantity = null;
      this.unit = "";
    },
    removeAlcohol(index) {
      this.alcoholTemp.splice(index, 1);
      this.alcohols.val.splice(index, 1);
    },
    removeIngredient(index) {
      this.ingredientTemp.splice(index, 1);
      this.ingredients.val.splice(index, 1);
    },
    addRecipe() {
      if (this.recipe !== "") {
        this.recipes.val.push(this.recipe);
        this.recipe = "";
      } else alert("레시피 내용을 입력해주세요.");
    },
    removeRecipe(index) {
      this.recipes.val.splice(index, 1);
    },
    clearValidity(input) {
      this[input].isValid = true;
    },
    validateForm() {
      this.formIsValid = true;

      if (this.title_kor.val === "") {
        this.title_kor.isValid = false;
        this.formIsValid = false;
        console.log("1");
      }
      // if (this.title_eng.val === "") {
      //   this.title_eng.isValid = false;
      //   this.formIsValid = false;
      // }
      else if (!this.abv.val || this.abv.val < 0) {
        this.abv.isValid = false;
        this.formIsValid = false;
        console.log("2");
      } else if (this.content.val === "") {
        this.content.isValid = false;
        this.formIsValid = false;
        console.log("3");
      } else if (this.cupinfo.val === "") {
        this.cupinfo.isValid = false;
        this.formIsValid = false;
        console.log("4");
      } else if (this.tags.val.length === 0) {
        this.tags.isValid = false;
        this.formIsValid = false;
        console.log("5");
      } else if (this.alcohols.val.length === 0) {
        this.alcohols.isValid = false;
        this.formIsValid = false;
        console.log("6");
      } else if (this.ingredients.val.length === 0) {
        this.ingredients.isValid = false;
        this.formIsValid = false;
        console.log("7");
      } else if (this.recipes.val.length === 0) {
        this.recipes.isValid = false;
        this.formIsValid = false;
        console.log("8");
      } else {
        this.formIsValid = true;
      }
    },
    async submitForm() {
      this.validateForm();

      if (!this.formIsValid) return;

      const formData = {
        category: this.category,
        img_path: this.img_path.val,
        title_kor: this.title_kor.val,
        title_eng: this.title_eng.val,
        abv: this.abv.val,
        content: this.content.val,
        cupinfo: this.cupinfo.val,
        tags: this.tags.val.join("<br>"), // default separator: ','
        alcohols: this.alcohols.val.join("<br>"),
        ingredients: this.ingredients.val.join("<br>"),
        recipes: this.recipes.val.join("<br>"),
      };

      console.log(formData);

      await this.$store.dispatch("recipes/registerRecipe", formData);
      this.$router.replace("/recipe/" + this.category);
    },
  },
};
/*
{
    "user_no": "user_no", 
    "title_kor": "title_kor",
    "title_eng": "title_eng",
    "created_at": "202102020122", 
    "content": "content",
    "img_path": "img_path",
    "category": "admin",
    "abv": "abv", 
    "cup_no": "cup_no",
    "alcohol": "보드카/15/ml,주류/진/15/ml,화이트 럼/15/ml,테킬라/15/ml,트리플 섹/15/ml",
    "ingredient": "재료/레몬 주스/25/ml,재료/설탕 시럽/30/ml,재료/콜라/1/캔,가니쉬/레몬 슬라이스/1/개",
    "tag": "tag1,tag2,tag3,tag4",
    "recipe": "recipe1,recipe2,recipe3"
},
{
    "user_no": "1", 
    "title_kor": "title_kor",
    "title_eng": "title_eng",
    "created_at": "202102021447", 
    "content": "content",
    "img_path": "img_path2",
    "category": "admin",
    "abv": "16", 
    "cup_no": "1",
    "alcohol": "그레이 구스/15/ml,진/15/ml,스미노프 No.21/15/ml,데킬라/15/ml,Kahlúa/15/ml",
    "ingredient": "재료/레몬 주스/25/ml,재료/토닉 워터/30/ml,재료/콜라/1/캔,가니쉬/레몬/1/개",
    "tag": "데킬라,보드카,레몬,맛있는",
    "recipe": "recipe1,recipe2,recipe3"
}
*/
</script>

<style scoped>
div {
  margin: 1rem 0;
}
.title {
  font-size: 48px;
  line-height: 93px;
}

#form-recipe select {
  padding: 0.5rem 1rem;
  border: 1px solid #ccc;
  border-radius: 1rem;
  margin-right: 1rem;
}

#form-recipe input,
#form-recipe textarea {
  padding: 0.5rem 1rem;
  border: 1px solid #ccc;
  border-radius: 1rem;
  margin-right: 1rem;
}

#form-recipe input:focus {
  outline: none;
  border-color: #1b995e;
  background-color: #d7fdeb;
}

.invalid p {
  color: #ff0000;
}

.invalid input,
.invalid select,
.invalid textarea {
  border: 1px solid #ff0000;
}

#card-margin {
  margin: 2rem auto;
}
</style>
