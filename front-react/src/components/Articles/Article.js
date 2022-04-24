import React from "react";

import "./Article.css"

class Article extends React.Component {

    deleteArticle = () => {
        fetch("http://localhost:8080/api/private/article/" + this.props.article.id,
        {
            method: 'DELETE',
        })
        .then(res => this.props.refreshArticles(res));
    }

    render () {
        const article = this.props.article;
        return <div className="article">
                <h4 className="title">{article.name} - {article.author} - {article.date}</h4>
                <p className="content">{article.content}</p>
                <button onClick={this.deleteArticle}>
                    Supprimer
                </button>
            </div>
    }
    
}

export default Article;