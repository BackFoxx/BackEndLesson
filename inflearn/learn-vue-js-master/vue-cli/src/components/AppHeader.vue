<template>
  <header>
      <h1>{{str}}</h1>
      <button v-on:click="sendEvent">send</button>
  </header>
</template>

<script>
export default {
    props: ['str'],
    methods: {
      sendEvent: function () {
        this.$emit('renew');
      }
    }
}
</script>

<style>

</style>