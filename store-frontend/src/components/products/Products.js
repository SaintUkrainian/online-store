import React, {useState, useEffect} from "react";
import axios from "axios";
import Spinner from "../UI/spinner/Spinner";
import Product from "./product/Product";

import "./Products.css"

function Products() {
    const [products, setProducts] = useState([]);
    const [fetchingProducts, setFetchingProducts] = useState(true);

    useEffect(() => {
        axios.get("/api/products/")
            .then(response => {
                setProducts(response.data);
                setFetchingProducts(false);
            })
            .catch(error => console.log(error));
    }, [])

    return (
        <div className={"Products"}>
            {fetchingProducts ? <Spinner /> : products.map(product => <Product key={product.id} product={product}/>)}
        </div>
    );
}

export default Products;