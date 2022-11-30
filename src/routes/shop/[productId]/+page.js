export const load = ({ fetch, params }) => {
  console.log(params);
  const { productId } = params;
  const fetchProduct = async (id) => {
    const product = await fetch(`https://dummyjson.com/products/${id}`);
    const productId = await product.json();
    return productId;
  };
  return {
    product: fetchProduct(productId),
  };
};
