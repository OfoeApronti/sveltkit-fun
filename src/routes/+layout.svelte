<script>
  import "../app.css";
</script>

<div class="flex min-h-full flex-col py-12 sm:px-6 lg:px-8 w-full">
  <div class="sm:mx-auto sm:w-full ">
    <nav class="flex pb-2 space-x-8">
      <a
        href="/"
        class="btn btn-primary bg-gray-300 p-2 rounded hover:bg-gray-400"
        >Home</a
      >
      <a href="/" class="btn bg-gray-300 p-2 rounded hover:bg-gray-400"
        >Contact</a
      >
      <a
        href="/shop"
        data-sveltekit-prefetch
        class="btn bg-gray-300 p-2 rounded hover:bg-gray-400">Shop</a
      >
      <a href="/movies" class="btn bg-gray-300 p-2 rounded hover:bg-gray-400"
        >Movies</a
      >
    </nav>
    <slot />
  </div>
</div>
