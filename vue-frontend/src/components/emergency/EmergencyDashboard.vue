<script setup>
import Header from "../menu/Header.vue";
import { useI18n } from 'vue-i18n';

const { t } = useI18n();
</script>

<template>
  <Header :componentName="t('emergencyDashboardTitle')" />
</template>

<style scoped>

</style>