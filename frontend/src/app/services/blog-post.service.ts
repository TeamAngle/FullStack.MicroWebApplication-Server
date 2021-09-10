import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient  } from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { BlogPost } from '../blogPost';

@Injectable({
  providedIn: 'root'
})
export class BlogPostService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getBlogPosts(): Observable<BlogPost[]> {
    return this.http.get<BlogPost[]>(`${this.apiServerUrl}/blogPostController/read`);
  }

  public getBlogPost(blogPostId: number): Observable<BlogPost> {
    return this.http.get<BlogPost>(`${this.apiServerUrl}/blogPostController/read/${blogPostId}`);
  }

  public addBlogPost(blogPost: BlogPost): Observable<BlogPost> {
    return this.http.post<BlogPost>(`${this.apiServerUrl}/blogPostController/create`, blogPost)
  }

  public updateBlogPost(blogPost: BlogPost, blogPostId: number): Observable<BlogPost> {
    return this.http.put<BlogPost>(`${this.apiServerUrl}/blogPostController/update/${blogPostId}`, blogPost);
  }

  public deleteBlogPost(blogPostId: number) : Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/blogPostController/delete/${blogPostId}`);
  }
}
