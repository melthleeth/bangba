<template>
    <div style="flex flex-row place-content-center">
        <section class="flex-1">
            <side-menu></side-menu>

        </section>
        <section class="flex-1">
            <article class="flex-col">
            <h1 class="text-5xl">프로필 변경</h1>
            <div>
                <img src="@/assets/img/mr.fox.jpg" class="h-12 w-12 cursor-pointer rounded-full border-2 border-gray-400 object-cover">
                
                <span>
                    <input type="text" />
                </span>
                
            </div>
            </article>
        </section>


    </div>
</template>

<script>
import SideMenu from '../../components/ui/SideMenu.vue'



export default {
  components: { SideMenu },
}
</script>

<style scoped>

</style>
