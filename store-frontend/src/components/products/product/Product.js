import React from "react";
import "./Product.css";

const product = (props) => {
    const {product} = props;
    return (
        <div className={"Product"}>
            <h1>{product.name}</h1>
            <img src={product.imageUrl} alt={product.name + " image"}/>
            <div className={"description"}>
                <p>{product.description}</p>
            </div>

        </div>
    );
}

export default product;