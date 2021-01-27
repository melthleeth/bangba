<template>
  <div>
    <img src="@/assets/img/BangBaJoin.png" />

    <h1>회원가입</h1>
    <h1>Sign up to Bang-Ba</h1>
    <!-- <h5>이메일 <input type="text" placeholder="coktail@bangba.com"> <base-button>인증메일 전송</base-button></h5> -->
    <!-- <h5> 인증 코드 입력 <input type="text" placeholder="이메일로 전송된 코드 입력"> <base-button>확인</base-button></h5> -->

    <div class="container">
      <form @submit.prevent="submitForm">
        <div class="joindiv">
          <label for="email">이메일 </label>
          <input type="text" id="email" class="textarea" v-model="email" />
          <base-button class="redbutton">인증메일 전송</base-button>
        </div>
        <div class="joindiv">
          <label for="code">인증코드 입력</label>
          <input type="text" id="code" v-model="code" class="textarea" />
          <base-button mode="outline">확인</base-button>
        </div>
        <div class="joindiv">
          <label for="phone_numver">전화번호</label>
          <input
            type="text"
            id="phone_numver"
            v-model="phone_numver"
            class="textarea"
          />
          <base-button class="redbutton">본인 인증</base-button>
        </div>
        <div class="joindiv">
          <label for="birthday">생년월일</label>
          <input type="date" class="date" />
          <!-- <v-date-picker v-model="date" /> -->
          <!-- <select id="year" name="year">
                  <option value="2021">2021</option>
                  <option value="saab">Saab</option>
                  <option value="fiat">Fiat</option>
                  <option value="audi">Audi</option>
                  
                </select>
                
				<select id="month" name="month">
                  <option value="01">01</option>
                  <option value="saab">Saab</option>
                  <option value="fiat">Fiat</option>
                  <option value="audi">Audi</option>
                </select>
                
                <select id="day" name="day">
                  <option value="25">25</option>
                  <option value="saab">Saab</option>
                  <option value="fiat">Fiat</option>
                  <option value="audi">Audi</option>
                </select> -->
        </div>
        <div class="joindiv">
          <label for="nickname">닉네임</label>
          <input
            type="nickname"
            id="nickname"
            v-model="nickname"
            class="textarea"
          />
          <base-button class="redbutton">중복 확인</base-button>
          <div class="alertText">
            *닉네임은 최소 2자, 최대 10자까지 입력이 가능해요.<br />* 회원가입
            후에도 자유롭게 변경할 수 있어요.
          </div>
        </div>
        <div class="joindiv">
          <label for="password">비밀번호</label>
          <input
            type="password"
            id="password"
            v-model="password"
            class="textarea"
          />
          <a>{{ message }}</a>
          <div class="alertText">
            * 비밀번호는 영문과 숫자를 반드시 포함해 최소 8자, 최대 20자까지
            입력이 가능해요.
          </div>
        </div>
        <div class="joindiv">
          <label for="passwordConfirm">비밀번호 확인</label>
          <input
            type="password"
            id="passwordConfirm"
            v-model="passwordConfirm"
            class="textarea"
          />
          <a>{{ message }}</a>
        </div>
        <div class="joindiv">
          <label
            ><input type="checkbox" name="check" value="check" />
            모든 이용약관 과 개인정보이용정책 에 동의합니다.
          </label>
        </div>

        <base-button>회원 가입</base-button>
        <base-button mode="outline">취소</base-button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      date: new Date(),
    };
  },
};
</script>

<style scope>
input {
  text-align: center;
  vertical-align: auto;
  margin: auto;
}

img {
  float: left;
  margin-right: 40px;
}
label {
  padding: 0.75rem 1.5rem;
}

.date,
select,
.textarea {
  text-decoration: none;
  padding: 0.75rem 1.5rem;
  font: inherit;
  border: 0.1px solid #ffffff;
  border-radius: 30px;
  margin-right: 0.5rem;
  display: inline-block;
  transition: 0.3s ease-out;
}
.joindiv {
  margin: 20px;
}

.alertText {
  color: #c6c6c6;
  margin-left: 600px;
}
</style>
