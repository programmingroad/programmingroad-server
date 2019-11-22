create schema if not exists programmingroad collate utf8mb4_0900_ai_ci;

create table if not exists tag
(
	id bigint auto_increment comment '主键'
		primary key,
	name varchar(32) default '' not null comment '标签名称',
	create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
	update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
	deleted tinyint(1) default 0 not null comment '是否删除 0未删 1删除'
)
comment '操作日志表';