CREATE SCHEMA diamond AUTHORIZATION diamond;

CREATE TABLE config_info (
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	data_id VARCHAR ( 255 ) NOT NULL,
	group_id VARCHAR ( 128 ) NOT NULL,
	tenant_id VARCHAR ( 128 ) DEFAULT '',
	app_name VARCHAR ( 128 ),
	content longtext,
	md5 VARCHAR ( 32 ) DEFAULT NULL,
	gmt_create TIMESTAMP NOT NULL DEFAULT '2010-05-05 00:00:00',
	gmt_modified TIMESTAMP NOT NULL DEFAULT '2010-05-05 00:00:00',
	src_user VARCHAR ( 128 ) DEFAULT NULL,
	src_ip VARCHAR ( 20 ) DEFAULT NULL,
	c_desc VARCHAR ( 256 ) DEFAULT NULL,
	c_use VARCHAR ( 64 ) DEFAULT NULL,
	effect VARCHAR ( 64 ) DEFAULT NULL,
	type VARCHAR ( 64 ) DEFAULT NULL,
	c_schema LONG VARCHAR DEFAULT NULL,
CONSTRAINT configinfo_id_key PRIMARY KEY ( id ),
CONSTRAINT uk_configinfo_datagrouptenant UNIQUE ( data_id, group_id, tenant_id ));

CREATE INDEX configinfo_dataid_key_idx ON config_info(data_id);
CREATE INDEX configinfo_groupid_key_idx ON config_info(group_id);
CREATE INDEX configinfo_dataid_group_key_idx ON config_info(data_id, group_id);

CREATE TABLE his_config_info (
  `id` bigint(64) unsigned NOT NULL,
  `nid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  tenant_id varchar(128) default '',
  app_name varchar(128),
  content longtext,
  md5 varchar(32) DEFAULT NULL,
  gmt_create timestamp NOT NULL DEFAULT '2010-05-05 00:00:00.000',
  gmt_modified timestamp NOT NULL DEFAULT '2010-05-05 00:00:00.000',
  src_user varchar(128),
  src_ip varchar(20) DEFAULT NULL,
  op_type char(10) DEFAULT NULL,
  constraint hisconfiginfo_nid_key PRIMARY KEY (nid));

CREATE INDEX hisconfiginfo_dataid_key_idx ON his_config_info(data_id);
CREATE INDEX hisconfiginfo_gmt_create_idx ON his_config_info(gmt_create);
CREATE INDEX hisconfiginfo_gmt_modified_idx ON his_config_info(gmt_modified);


CREATE TABLE config_info_beta (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  tenant_id varchar(128) default '',
  app_name varchar(128),
  content longtext,
  beta_ips varchar(1024),
  md5 varchar(32) DEFAULT NULL,
  gmt_create timestamp NOT NULL DEFAULT '2010-05-05 00:00:00',
  gmt_modified timestamp NOT NULL DEFAULT '2010-05-05 00:00:00',
  src_user varchar(128),
  src_ip varchar(20) DEFAULT NULL,
  constraint configinfobeta_id_key PRIMARY KEY (id),
  constraint uk_configinfobeta_datagrouptenant UNIQUE (data_id,group_id,tenant_id));

CREATE TABLE config_info_tag (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  tenant_id varchar(128) default '',
  tag_id varchar(128) NOT NULL,
  app_name varchar(128),
  content longtext,
  md5 varchar(32) DEFAULT NULL,
  gmt_create timestamp NOT NULL DEFAULT '2010-05-05 00:00:00',
  gmt_modified timestamp NOT NULL DEFAULT '2010-05-05 00:00:00',
  src_user varchar(128),
  src_ip varchar(20) DEFAULT NULL,
  constraint configinfotag_id_key PRIMARY KEY (id),
  constraint uk_configinfotag_datagrouptenanttag UNIQUE (data_id,group_id,tenant_id,tag_id));

CREATE TABLE config_info_aggr (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  tenant_id varchar(128) default '',
  datum_id varchar(255) NOT NULL,
  app_name varchar(128),
  content longtext,
  gmt_modified timestamp NOT NULL DEFAULT '2010-05-05 00:00:00',
  constraint configinfoaggr_id_key PRIMARY KEY (id),
  constraint uk_configinfoaggr_datagrouptenantdatum UNIQUE (data_id,group_id,tenant_id,datum_id));

CREATE TABLE app_list (
 id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
 app_name varchar(128) NOT NULL,
 is_dynamic_collect_disabled smallint DEFAULT 0,
 last_sub_info_collected_time timestamp DEFAULT '2010-05-05 00:00:00',
 sub_info_lock_owner varchar(128),
 sub_info_lock_time timestamp DEFAULT '2010-05-05 00:00:00',
 constraint applist_id_key PRIMARY KEY (id),
 constraint uk_appname UNIQUE (app_name));

CREATE TABLE app_configdata_relation_subs (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  app_name varchar(128) NOT NULL,
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  gmt_modified timestamp DEFAULT '2010-05-05 00:00:00',
  constraint configdatarelationsubs_id_key PRIMARY KEY (id),
  constraint uk_app_sub_config_datagroup UNIQUE (app_name, data_id, group_id));


CREATE TABLE app_configdata_relation_pubs (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  app_name varchar(128) NOT NULL,
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  gmt_modified timestamp DEFAULT '2010-05-05 00:00:00',
  constraint configdatarelationpubs_id_key PRIMARY KEY (id),
  constraint uk_app_pub_config_datagroup UNIQUE (app_name, data_id, group_id));

CREATE TABLE config_tags_relation (
  id bigint NOT NULL,
  tag_name varchar(128) NOT NULL,
  tag_type varchar(64) DEFAULT NULL,
  data_id varchar(255) NOT NULL,
  group_id varchar(128) NOT NULL,
  tenant_id varchar(128) DEFAULT '',
  nid bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  constraint config_tags_id_key PRIMARY KEY (nid),
  constraint uk_configtagrelation_configidtag UNIQUE (id, tag_name, tag_type));

CREATE INDEX config_tags_tenant_id_idx ON config_tags_relation(tenant_id);

CREATE TABLE group_capacity (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  group_id varchar(128) DEFAULT '',
  quota int DEFAULT 0,
  usage int DEFAULT 0,
  max_size int DEFAULT 0,
  max_aggr_count int DEFAULT 0,
  max_aggr_size int DEFAULT 0,
  max_history_count int DEFAULT 0,
  gmt_create timestamp DEFAULT '2010-05-05 00:00:00',
  gmt_modified timestamp DEFAULT '2010-05-05 00:00:00',
  constraint group_capacity_id_key PRIMARY KEY (id),
  constraint uk_group_id UNIQUE (group_id));

CREATE TABLE tenant_capacity (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  tenant_id varchar(128) DEFAULT '',
  quota int DEFAULT 0,
  `usage` int DEFAULT 0,
  max_size int DEFAULT 0,
  max_aggr_count int DEFAULT 0,
  max_aggr_size int DEFAULT 0,
  max_history_count int DEFAULT 0,
  gmt_create timestamp DEFAULT '2010-05-05 00:00:00',
  gmt_modified timestamp DEFAULT '2010-05-05 00:00:00',
  constraint tenant_capacity_id_key PRIMARY KEY (id),
  constraint uk_tenant_id UNIQUE (tenant_id));

CREATE TABLE tenant_info (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  kp varchar(128) NOT NULL,
  tenant_id varchar(128)  DEFAULT '',
  tenant_name varchar(128)  DEFAULT '',
  tenant_desc varchar(256)  DEFAULT NULL,
  create_source varchar(32) DEFAULT NULL,
  gmt_create bigint NOT NULL,
  gmt_modified bigint NOT NULL,
  constraint tenant_info_id_key PRIMARY KEY (id),
  constraint uk_tenant_info_kptenantid UNIQUE (kp,tenant_id));
CREATE INDEX tenant_info_tenant_id_idx ON tenant_info(tenant_id);


CREATE TABLE users (
	username varchar(50) NOT NULL PRIMARY KEY,
	password varchar(500) NOT NULL,
	enabled boolean NOT NULL
);

CREATE TABLE roles (
	username varchar(50) NOT NULL,
	role varchar(50) NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

INSERT INTO roles (username, role) VALUES ('nacos', 'ROLE_ADMIN');
