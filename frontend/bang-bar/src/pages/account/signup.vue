<template>
    

    <img src="@/assets/img/BangBaJoin.png"/>
    <h1 style="text-align:left">회원가입<br>Sign up to Bang-Ba</h1>

	<div class="container">
        
		<form @submit.prevent="submitForm">
			<div class="joindiv">
				<label for="email">이메일 </label> 
				<input type="text" id="email" class="textarea" v-model="email" placeholder="cocktail@bangba.com"/>
                <base-button class="redbutton">인증메일 전송</base-button>
			</div>
            <div class="joindiv" >
                <label for="code">인증코드 입력</label>
                <input type="text" id="code" v-model="code" class="textarea" placeholder="이메일로 전송된 코드 입력"/>
                <base-button mode="outline" >확인</base-button>
            </div>
			<div class="joindiv">
				<label for="phone_numver">전화번호</label>
				<input type="text" id="phone_numver" v-model="phone_numver" class="textarea" placeholder="01012345678"/>
                <base-button class="redbutton">본인 인증</base-button>
			</div>
            <div class="joindiv">
				<label for="birthday">생년월일</label>
                <input type="date" class="date">               
                
			</div>
			<div class="joindiv">
				<label for="nickname">닉네임</label>
				<input type="nickname" id="nickname" v-model="nickname" class="textarea"/>
                <base-button class="redbutton">중복 확인</base-button>
                <div class="alertText">*닉네임은 최소 2자, 최대 10자까지 입력이 가능해요.<br>* 회원가입 후에도 자유롭게 변경할 수 있어요.</div>
			</div>
            <div class="joindiv">
				<label for="password">비밀번호</label>
				<input type="password" id="password" v-model="password" class="textarea"/>
                <a>{{ message }}</a>
                <div class="alertText">* 비밀번호는 영문과 숫자를 반드시 포함해 최소 8자, 최대 20자까지 입력이 가능해요.</div>
			</div>
			<div class="joindiv">
				<label for="passwordConfirm">비밀번호 확인</label>
				<input type="password" id="passwordConfirm" v-model="passwordConfirm" class="textarea" />
                <a>{{ message }}</a>
			</div>
			<div class="joindiv">
				<label><input type="checkbox" name="check" value="check"> </label>
                모든 


                <base-modal @close="hideDialog" :open="dialogIsVisible_terms">
                    <section class="modal-header">
                        <img src="../../assets/img/logo.png" />
                    </section>

                    이용약관

                    <section class="button-modal">
                        <base-button @click="hideDialog_terms" mode="outline">취소</base-button>
                    </section>
                </base-modal>
                <span  @click="showDialog_terms" style="text-decoration:underline; font-weight:bold">
                    이용약관
                </span>
                과 
                 <base-modal @close="hideDialog" :open="dialogIsVisible_personal">
                    <section class="modal-header">
                        <img src="../../assets/img/logo.png" />
                    </section>
                    개인정보이용정책
                    <section class="button-modal">
                        <base-button @click="hideDialog_personal" mode="outline">취소</base-button>
                    </section>
                </base-modal>
                <span @click="showDialog_personal"  style="text-decoration:underline; font-weight:bold">
                    개인정보이용정책
                </span>
                에 동의합니다.
			</div>
            <div style="text-align:left">
			<base-button>회원 가입</base-button>
            <base-button mode="outline">취소</base-button>
            </div>
		</form>
	</div>
</template>

<script>
export default {
  data() {
    return {
      date: new Date(),
      dialogIsVisible_terms: false,
      dialogIsVisible_personal: false,
      };
    },
    methods: {
    showDialog_terms() {
      this.dialogIsVisible_terms = true;
    },
    hideDialog_terms() {
      this.dialogIsVisible_terms = false;
    },
    showDialog_personal() {
      this.dialogIsVisible_personal = true;
    },
    hideDialog_personal() {
      this.dialogIsVisible_personal = false;
    },
  },
}
</script>

<style scope>
input {
  text-align: center;
  vertical-align: auto;
  margin: auto;
}
    h1{
        text-align: left;
    }

    img {
        /* text-align: left; */
        /* display: ; */
        float:left;
        /* align-content:inherit; */
        margin-right: 40px;
    }
    label {
        padding: 0.75rem 1.5rem;
        font-weight: 500;

    }



    .date,
    .textarea{
        text-decoration: none;
        padding: 0.75rem 1.5rem;
        font: inherit;
        border: 0.1px solid #FFFFFF;
        border-radius: 30px;
        margin-right: 0.5rem;
        display: inline-block;
        transition: .3s ease-out;
    }
    .joindiv {
        margin: 20px;
    }


    .alertText {
        color:#C6C6C6;
        margin-left: 600px;
    }

    ::placeholder{
        color: #C6C6C6;
    }
</style>