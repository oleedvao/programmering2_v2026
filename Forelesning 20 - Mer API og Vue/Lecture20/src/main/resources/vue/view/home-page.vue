<template id="home-page-template">
  <h1 class="header">Welcome to the Zoo Register!</h1>
  <h2>Who let the dogs out!</h2>
</template>

<script>
app.component("home-page", {
  template: "#home-page-template"
})
</script>

<style>
.header {
  color: goldenrod;
  font-size: 50px;
}
</style>