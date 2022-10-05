<template>

    <div class="background" >   </div>
    
</template>

<script>


export default {
    name: 'BackGround',
    
}
</script>

<style scoped>
* {
  margin: 0px;
  padding: 0px;
}


.background{
    width: 100%;
    height: 100%;
    position: fixed;
    filter: blur(5px);
    z-index: -1;
    margin: 0;
    padding: 0;
	border:0;
    background-size: cover;
    transform: scale(1.1);
    position: left 10%;
    background-image: url('@/assets/bg.jpg');
    
 }

 /* .backgrond img{
    width: 100%;
    height: 100%;
    object-fit: cover;
    transform: scale(1.1);
    object-position: left 10%;
    background-attachment: fixed;
 } */
</style>