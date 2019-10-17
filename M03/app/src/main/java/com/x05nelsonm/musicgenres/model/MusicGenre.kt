package com.x05nelsonm.musicgenres.model

sealed class MusicGenre (val name: String)

class Rock (name: String): MusicGenre(name)
class HeavyMetal (name: String): MusicGenre(name)
class MetalCore (name: String): MusicGenre(name)
class TechnoCore (name: String): MusicGenre(name)
class MichaelJackson (name: String): MusicGenre(name)
