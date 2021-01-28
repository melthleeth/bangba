<template>
    <div  class="">
        <container class="bg-green-500 flex flex-col" >
            <ul >
                <li @click="goProfile()"> 프로필 / 개인정보 수정</li>
                <li @click="goBookmark()">북마크한 레시피</li>
                <li @click="goMyposts()">내가 쓴 글</li>
                <li @click="goLog()">활동 기록</li>
                <li @click="goFollow()">팔로잉 / 팔로워</li>
            </ul>


            <button>탈퇴하기</button>
        </container>
    </div>
</template>

<script>
export default {
    methods: {
        clickit(){
            alert("gg");
        },
        goProfile(){
            this.$router.push({
                path: `/header/editprofile`
            });
        },
        goBookmark(){
            this.$router.push({
                path: `/header/goBookmark`
            });
        },
        goMyposts(){
            this.$router.push({
                path: `/header/myposts`
            });
        },
        goLog(){
            this.$router.push({
                path: `/header/activitylog`
            });
        },
        goFollow(){
            this.$router.push({
                path: `/header/followingfollowers`
            });
        }

    },
}
</script>

<style scoped>

</style>
