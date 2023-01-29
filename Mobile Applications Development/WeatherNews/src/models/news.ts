export interface Headlines {
  status: string;
  totalResults: number;
  articles: Article[];
}

export interface Article {
  source: {
    id: null | string;
    name: string;
  };
  author: null | string;
  title: string;
  description: null | string;
  url: string;
  urlToImage: null | string;
  // publishedAt: Date;
  // content: null | string;
}
