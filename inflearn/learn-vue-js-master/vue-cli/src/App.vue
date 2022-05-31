<template>
  <div>
    <app-header 
      v-bind:str="str"
      v-on:renew="renewStr">
    </app-header>
    {{str}}
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'

export default {
  data: function () {
    return {
      str: 'header!!'  
    }
  },
  components: {
    'app-header': AppHeader
  },
  methods: {
    renewStr: function() {
      this.str = 'hi';
    }
  }
}
</script>

<style>

</style>