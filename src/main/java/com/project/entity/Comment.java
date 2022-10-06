package com.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter @Setter
public class Comment extends BaseTimeEntity {
	
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commenter")
	private Member member;					// 댓글 작성자
		/*
		 * 회원 한명이 여러개의 댓글을 작성할 수 있음
		 * 	-> Comment : Member = 다 : 일
		 * 	-> Many To One
		 * 
		 * */
	
	private String content;					// 댓글 내용
	
	private LocalDateTime regDate;			// 등록일자
	
	private LocalDateTime editDate;			// 수정일자
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
		/*
		 * 한개의 게시물에는 여러개의 댓글이 달릴 수 있음
		 * 	-> Comment : Post = 다 : 일
		 * 	-> Many To One
		 * 
		 * */

}
