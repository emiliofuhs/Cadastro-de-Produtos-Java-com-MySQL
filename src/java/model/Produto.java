/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



public class Produto {

    private int id;
    private String nome;
    private String veiculo;
    private float pesoLiquido;
    private float pesoBruto;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
    public float getPesoLiquido() {
        return pesoLiquido;
    }
    public void setPesoLiquido(float pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
       
    }
    public float getPesoBruto() {
        return pesoBruto;
    }
    public void setPesoBruto(float pesoBruto) {
        this.pesoBruto = pesoBruto;
    }
   // @Override
   // public String toString() {
       //return "Prodtuto [id=" + id + ", nome=" + nome + ", veiculo=" + veiculo + ", pesoliquido=" + pesoLiquido + ", pesobruto=" + pesoBruto + "]";
    }    
//}