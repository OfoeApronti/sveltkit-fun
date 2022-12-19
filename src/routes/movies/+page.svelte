<script>
  export let data;
  let { movies } = data;
  console.log(data);
</script>

<h1>Movies</h1>

{#each movies as movie}
<div class="mt-4">
  <h2 class="text-xl font-semibold">{movie.title}</h2>
  <p>{movie.overview}</p>
</div>
  
{/each}

