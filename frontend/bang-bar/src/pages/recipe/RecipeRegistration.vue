<template>
  <div class="font-S-CoreDream-light flex flex-col justify-items-center mx-16">
    <span class="title text-center my-10 font-S-CoreDream-medium font-bold"
      >{{ mode }} 레시피 등록</span
    >
    <base-card>
      <form class="text-lg" id="form-recipe" @submit.prevent="submitForm">
        <div class="form-control" :class="{ invalid: !img_path.isValid }">
          <label for="img_path">사진 등록</label>
          <img src="img_path.val" alt="cocktail image" />
          <base-button @click="showImgRegDialog">사진 등록</base-button>
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
          <p v-if="!title_kor.isValid">칵테일 이름은 비어있으면 안됩니다.</p>
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
          <p v-if="!title_eng.isValid">칵테일 영문명은 비어있으면 안됩니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !content.isValid }">
          <label for="content">칵테일 소개</label>
          <textarea
            class="w-1/3"
            id="content"
            rows="3"
            placeholder="어떤 칵테일인지 소개 해주세요"
            v-model.trim="content.val"
            @blur="clearValidity('content')"
          ></textarea>
          <p v-if="!content.isValid">칵테일 소개는 비어있으면 안됩니다.</p>
        </div>
        <div class="form-control" :class="{ invalid: !tags.isValid }">
          <label for="tag">태그</label>
          <input class="w-1/12" type="text" id="tag" v-model.trim="tag" />
          <base-button @click="addTag">추가하기</base-button>
          <section>
            <!-- 중복 항목 검사 테스트 필요 -->
            <span class="mr-4" v-for="(tag, index) in tags.val" :key="tag">
              {{ tag }}
              <span class="ml-2 text-grey-400 cursor-pointer hover:text-red-400" @click="removeTag(index)"
                >x</span
              >
            </span>
          </section>
          <p v-if="!tags.isValid">최소 하나의 태그를 추가해주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !ingredients.isValid }">
          <label for="ingredients">재료 추가하기</label>
          <select class="w-1/12" name="type" id="type" v-model="type">
            <option value="">분류</option>
            <option value="type-alcohol">주류</option>
            <option value="type-ingredient">재료</option>
            <option value="type-garnish">가니쉬</option>
          </select>
          <input
            class="w-1/12"
            type="text"
            id="ingredient"
            placeholder="보드카"
            v-model.trim="ingredient"
          />
          <input
            class="w-1/12"
            type="number"
            id="quantity"
            placeholder="30"
            v-model.number="quantity"
          />
          <input
            class="w-1/12"
            type="text"
            id="unit"
            placeholder="ml"
            v-model.trim="unit"
          />
          <base-button @click="addIngredient">추가하기</base-button>
          <ul>
            <li
              v-for="(ingredientItem, index) in ingredientTemp"
              :key="ingredientItem">
              <span> - {{ ingredientItem }}</span>
              <span class="ml-2 text-grey-400 cursor-pointer hover:text-red-400" @click="removeIngredient(index)"
                >x</span
              >
            </li>
          </ul>
          <p v-if="!ingredients.isValid">최소 한 가지의 재료를 추가해주세요.</p>
        </div>
        <div class="form-control" :class="{ invalid: !recipes.isValid }">
          <label for="recipes">레시피 추가하기</label>
          <input
            class="w-1/3 text-left"
            type="text"
            id="recipe"
            placeholder="레시피를 입력하세요"
            v-model.trim="recipe"
          />
          <base-button @click="addRecipe">추가하기</base-button>
          <ul>
            <li
              v-for="(recipeItem, index) in recipes.val"
              :key="recipeItem"
            >
              <span>{{ index + 1 }}. {{ recipeItem }}</span>
              <span class="ml-2 text-grey-400 cursor-pointer hover:text-red-400" @click="removeRecipe(index)"
                >x</span
              >
            </li>
          </ul>
          <p v-if="!recipes.isValid">최소 한 가지 순서를 추가해주세요.</p>
        </div>
        <p v-if="!formIsValid">
          비어있는 칸이 있습니다. 채운 후 다시 시도해주세요.
        </p>
        <base-button>레시피 등록하기</base-button>
      </form>
    </base-card>
  </div>
</template>

<script>
export default {
  props: {
    mode: {
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
      tag: "",
      type: "",
      ingredient: "",
      quantity: null,
      unit: "",
      recipe: "",
      ingredientTemp: [],
      img_path: {
        val: "../../assets/img/defaultCocktailImage.png",
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
      content: {
        val: "",
        isValid: true,
      },
      tags: {
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
      console.log("사진 등록 중");
      alert("사진 등록 기능 준비중");
    },
    addTag() {
      if (this.tag !== "") {
        this.tags.val.push(this.tag);
        this.tag = "";
      } else alert("태그 내용을 입력해주세요.");
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
      if (!this.quantity || this.quantity < 0) {
        alert("용량을 입력해주세요.");
        return;
      }
      if (this.unit === "") {
        alert("단위를 입력해주세요.");
        return;
      }

      const ingredientTempItem = `${this.ingredient} ${this.quantity}${this.unit}`;
      const ingredientItem = `${this.type}/${this.ingredient}/${this.quantity}/${this.unit}`;

      this.ingredientTemp.push(ingredientTempItem);
      this.ingredients.val.push(ingredientItem);
      alert(this.type + " (" + this.ingredient + ")가 추가되었습니다.");

      this.type = "";
      this.ingredient = "";
      this.quantity = null;
      this.unit = "";
      
      console.log(this.ingredients.val);
      console.log(this.ingredientTemp);
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
      if (this.title_kor.val === "") {
        this.title_kor.isValid = false;
        this.formIsValid = false;
      }
      if (this.title_eng.val === "") {
        this.title_eng.isValid = false;
        this.formIsValid = false;
      }
      if (this.content.val === "") {
        this.content.isValid = false;
        this.formIsValid = false;
      }
      if (this.tags.val.length === 0) {
        this.tags.isValid = false;
        this.formIsValid = false;
      }
      if (this.ingredients.val.length === 0) {
        this.ingredients.isValid = false;
        this.formIsValid = false;
      }
      if (this.recipes.val.length === 0) {
        this.recipes.isValid = false;
        this.formIsValid = false;
      }
    },
    async submitForm() {
      this.validateForm();

      if (!this.formIsValid) return;

      const formData = {
        category: this.mode,
        img_path: this.img_path.val,
        title_kor: this.title_kor.val,
        title_eng: this.title_eng.val,
        content: this.content.val,
        tags: this.tags.val,
        ingredients: this.ingredients.val,
        recipes: this.recipes.val,
      };

      await this.$store.dispatch("registerRecipe", formData);
      this.$router.replace("/recipe/" + this.mode);
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
  color: red;
}

.invalid input,
.invalid select,
.invalid textarea {
  border: 1px solid red;
}
</style>
