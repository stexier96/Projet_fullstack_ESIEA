import React, { Component } from 'react'
import Article from './Article'
import FormArticle from './FormArticle'


class Articles extends Component {

    state = {
        articles: [],
    }
    getArticles = () => {
        const categoryId = this.props.category.categoryId;
        fetch("http://localhost:8080/api/private/article/categoryId/" + categoryId)
        .then(res => res ? res.json() : undefined)
        .then(res => res ? this.setState({articles: res}) : this.setState({articles: []}));
    }
    
    
    componentDidMount() {
        this.getArticles()
    }

    render () {
        return (
            <div>
                <FormArticle 
                refreshArticles={article =>
                    this.getArticles()
                }
                category={this.props.category}/>
                <div>
                    {this.state.articles.map(article => (
                        <Article key={article.id} article={article}/>
                    ))}
                </div>
            </div>
        )
    }
}

export default Articles;