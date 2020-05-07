<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"></xsl:output>

    <xsl:template match="Purchase0rder">
        <h1 align="center">David Enterprises Inc., Carolina West , USA</h1>

        <p>
        <xsl:apply-templates select="PONumber"/>
        <xsl:apply-templates select="PODate"/>
        <xsl:apply-templates select="Seller"/>
        <xsl:apply-templates select="Buyer"/>
        <xsl:apply-templates select="DeliveryDate"/>
        </p>

        <h3>Shipping Details</h3>
        <xsl:apply-templates select="ShipTo"/>
        <h3>Billing Details</h3>
        <xsl:apply-templates select="BillTo"/>
        <h3>Product Details</h3>
        <xsl:apply-templates select="Products"/>

        <xsl:apply-templates select="Instructions"/>
    </xsl:template>

    <xsl:template match="PONumber">
        Purchase Order Number:
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <xsl:template match="PODate">
        Purchase Order Date:
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <xsl:template match="Seller">
        Seller:
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <xsl:template match="Buyer">
        Buyer:
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <xsl:template match="DeliveryDate">
        Delivery Date:
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <!-- Shipping Details -->

    <xsl:template match="ShipTo">
        Name: <xsl:value-of select="Name"/> <br/>
        Street: <xsl:value-of select="Street"/> <br/>
        CityZip: <xsl:value-of select="CityZip"/> <br/>
        Country: <xsl:value-of select="Country"/> <br/>
    </xsl:template>

    <!-- Billing Details -->

    <xsl:template match="BillTo">
        Name: <xsl:value-of select="Name"/> <br/>
        Street: <xsl:value-of select="Street"/> <br/>
        CityZip: <xsl:value-of select="CityZip"/> <br/>
        Country: <xsl:value-of select="Country"/> <br/>
    </xsl:template>

    <!-- Product Details -->

    <xsl:template match="Product">
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <!-- Instructions -->

    <xsl:template match="Instruction">
        <br/>
        <xsl:value-of select="."/>
    </xsl:template>
</xsl:stylesheet>