import React, { Component } from "react";
import Articles from "../Articles/Articles";

import "./Category.css"

class Category extends Component {

    state = {
        isHidden: true
    }

    toggleHidden () {
        this.setState({
          isHidden: !this.state.isHidden
        })
    }

    render() {
        return (
            <div className="category">
                <div onClick={this.toggleHidden.bind(this)}>
                    <h3 className="name">Articles de la catégorie {this.props.category.name} : </h3>
                </div>
                {this.state.isHidden ? '' : <Articles category={this.props.category}/>}
            </div>
        )
    }
}

export default Category;