export const load = async ({ fetch }) => {
  const fetchProducts = async () => {
    const productRes = await fetch("https://dummyjson.com/products?limit=10");
    const productData = await productRes.json();
    return productData.products;
  };

  const fetchUsers = async () => {
    const usersRes = await fetch("https://dummyjson.com/users?limit=10");
    const userData = await usersRes.json();
    return userData.products;
  };
  return {
    products: fetchProducts(),
    users: fetchUsers(),
  };
};
//https://dummyjson.com/products?limit=10
