--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2018-12-07 15:29:51 -02

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2908 (class 1262 OID 16384)
-- Name: produto; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE produto WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE produto OWNER TO postgres;

\connect produto

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16390)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    descricao character varying(20) NOT NULL,
    vencimento character varying(8),
    vendedor character varying(20)
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16385)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    login character varying(20) NOT NULL,
    senha character varying(20),
    perfil character varying(50),
    email character varying(50)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 2781 (class 2606 OID 16394)
-- Name: produto chaveproduto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT chaveproduto PRIMARY KEY (descricao);


--
-- TOC entry 2779 (class 2606 OID 16389)
-- Name: usuario chaveusuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT chaveusuario PRIMARY KEY (login);


-- Completed on 2018-12-07 15:29:51 -02

--
-- PostgreSQL database dump complete
--

