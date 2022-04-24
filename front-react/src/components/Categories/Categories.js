import React, { Component } from 'react'
import Category from './Category'
import FormCategories from './FormCategory';

import "./Categories.css"

class Categories extends Component {

    state = {
        categories: [],
    }
    getCategories = () => {
        fetch("http://localhost:8080/api/private/category")
        .then(res => res.json())
        .then(res => this.setState({categories: res}));
    }
    
    componentDidMount() {
        this.getCategories()
    }

    render () {
        const {categories} = this.state;
        return (
            <div className='categories'>
                <h2>Veuillez sélectionner ou ajouter une catégorie : </h2>
                <FormCategories refreshCategories={category =>
                    this.getCategories()
                } />
                <div>
                    {categories.map(category => (
                        <Category key={category.categoryId} category={category}/>
                    ))}
                </div>
            </div>
        )
    }
}

export default Categories;