<template>
    <button :class="mode">
        <slot></slot>
    </button>
</template>

<script>
export default {
    props: {
        mode: {
            type: String,
            required: false,
            default: null
        },
        link: {
            type: Boolean,
            required: false,
            default: false,
        },
        to: {
            type: String,
            required: false,
            default: '/'
        }
    }
}
</script>

<style scoped>
button,
a {
  text-decoration: none;
  padding: 0.75rem 1.5rem;
  font: inherit;
  background-color: #00002F;
  border: 1px solid #00002F;
  color: white;
  cursor: pointer;
  border-radius: 30px;
  margin-right: 0.5rem;
  display: inline-block;
  transition: .3s ease-out;
}


a:hover,
a:active,
button:hover,
button:active {
    color: #FF5E46;
}

.flat {
  background-color: transparent;
  color: #270041;
  border: none;
}

.outline {
  background-color: transparent;
  border: 3px solid #00002F;
  color: #00002F;
}

.flat:hover,
.flat:active,
.outline:hover,
.outline:active {
    color: white;
  background-color: #00002F;
}
</style>